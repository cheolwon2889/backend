package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.ContainerVO;

@Service("ContainerRecommendationService")
public class ContainerRecommendationService {

	public void calculateContainerRecommendation(List<ContainerVO> containerVOList) {
	    // 미리 정의된 포트 목록
	    String portString = "Busan,Shanghai,Singapore,Rotterdam,Los Angeles";
	    List<String> portList = Arrays.asList(portString.split(","));

	    // (1) 포트별로 분류한 뒤 정렬된 컨테이너 목록 저장
	    List<List<Map<String, Object>>> sortedContainersByPort = new ArrayList<>();
	    
	    // (2) 최종적으로 100개씩 맞춰서 재정렬된 컨테이너 목록
	    List<List<Map<String, Object>>> refinedContainersByPort = new ArrayList<>();
	    
	    // (3) 최종 10x10 형태로 배치된 컨테이너 목록
	    List<List<Map<String, Object>>> finalArrangedContainers = new ArrayList<>();

	    // (A) 각 포트를 순회하며 해당 포트에 있는 컨테이너 목록을 무게 내림차순으로 정렬
	    for (String port : portList) {
	        List<Map<String, Object>> portContainers = new ArrayList<>();

	        for (ContainerVO container : containerVOList) {
	            if (container.getPort().equals(port)) {
	                Map<String, Object> containerMap = new HashMap<>();
	                containerMap.put("ID", container.getId());
	                containerMap.put("Weight", container.getWeight());
	                portContainers.add(containerMap);
	            }
	        }

	        // 내림차순(무게 기준) 정렬
	        portContainers.sort((a, b) -> Double.compare((double) b.get("Weight"), (double) a.get("Weight")));
	        sortedContainersByPort.add(portContainers);
	    }

	    // (B) 각 포트별 컨테이너를 100개씩 맞추고, 초과/부족분을 앞뒤 포트에서 조정
	    List<Map<String, Object>> carryOverContainers = new ArrayList<>();
	    for (int i = 0; i < sortedContainersByPort.size(); i++) {
	        // 기존 carryOverContainers + 현재 포트 컨테이너
	        List<Map<String, Object>> combinedList = new ArrayList<>(carryOverContainers);
	        combinedList.addAll(sortedContainersByPort.get(i));

	        // carryOverContainers 초기화
	        carryOverContainers.clear();

	        // 컨테이너가 100개 이하인 경우 -> 다음 포트에서 부족분 보충
	        if (combinedList.size() < 100) {
	            int nextPortIndex = i + 1;
	            while (combinedList.size() < 100 && nextPortIndex < sortedContainersByPort.size()) {
	                List<Map<String, Object>> nextPortContainers = sortedContainersByPort.get(nextPortIndex);
	                while (combinedList.size() < 100 && !nextPortContainers.isEmpty()) {
	                    combinedList.add(nextPortContainers.remove(nextPortContainers.size() - 1));
	                }
	                nextPortIndex++;
	            }
	        }

	        // 컨테이너가 100개를 초과하는 경우 -> 초과분은 carryOverContainers에 저장
	        if (combinedList.size() > 100) {
	            carryOverContainers.addAll(combinedList.subList(100, combinedList.size()));
	            combinedList = combinedList.subList(0, 100);
	        }

	        // 최종 정렬 후 refinedContainersByPort 리스트에 저장
	        if (!combinedList.isEmpty()) {
	            combinedList.sort((a, b) -> Double.compare((double) b.get("Weight"), (double) a.get("Weight")));
	            refinedContainersByPort.add(combinedList);
	        }
	    }

	    // (C) 실제로 10x10 형태로 배치하기 위한 인덱스 목록
	    List<Integer> startColumnIndexes = Arrays.asList(4, 5);
	    List<Integer> middleColumnIndexes = Arrays.asList(3, 6, 2, 7, 1, 8);
	    List<Integer> endColumnIndexes = Arrays.asList(0, 9);

	    // (D) 10x10 형태로 최종 재배치
	    for (int index = 0; index < refinedContainersByPort.size(); index++) {
	        // index 번째 포트 데이터 100개
	        List<Map<String, Object>> portData = refinedContainersByPort.get(index);
	        
	        // 10x10 형태로 배치할 임시 2차원 배열
	        @SuppressWarnings("unchecked")
	        Map<String, Object>[][] arrangedMatrix = new Map[10][10];

	        // 시작/중간/끝 포인터
	        int startPointer = 0;    // startColumnIndexes 배치 시 사용
	        int middlePointer = 20;  // middleColumnIndexes 배치 시 사용
	        int endPointer = 99;     // endColumnIndexes 배치 시 사용

	        // 행 번호 조정
	        int currentRow = 5;
	        // true이면 행 번호 증가 방향(양수), false이면 행 번호 감소 방향(음수)
	        boolean isIncreasingRow = true;

	        for (int rowIncrement = 0; rowIncrement < 10; rowIncrement++) {
	            // 행 인덱스 계산
	            if (isIncreasingRow) {
	                currentRow += rowIncrement;  // 5 -> 5+1 -> 6+2 -> ...
	            } else {
	                currentRow -= rowIncrement;  // 5 -> 5-1 -> 4-2 -> ...
	            }

	            // 한 행에 대해 열(0~9)에 따라 값을 배치
	            for (int col = 0; col < 10; col++) {
	                if (startColumnIndexes.contains(col)) {
	                    arrangedMatrix[currentRow][col] = portData.get(startPointer);
	                    startPointer++;
	                } else if (middleColumnIndexes.contains(col)) {
	                    arrangedMatrix[currentRow][col] = portData.get(middlePointer);
	                    middlePointer++;
	                } else if (endColumnIndexes.contains(col)) {
	                    arrangedMatrix[currentRow][col] = portData.get(endPointer);
	                    endPointer--;
	                }
	            }
	            // 행 증가/감소 방향 토글
	            isIncreasingRow = !isIncreasingRow;
	        }

	        // 2차원 배열에서 null이 아닌 데이터만 추출하여 최종 리스트에 추가
	        List<Map<String, Object>> arrangedList = new ArrayList<>();
	        for (int row = 0; row < arrangedMatrix.length; row++) {
	            for (int col = 0; col < arrangedMatrix[row].length; col++) {
	                Map<String, Object> map = arrangedMatrix[row][col];
	                if (map != null) {
	                    arrangedList.add(map);
	                }
	            }
	        }
	        finalArrangedContainers.add(arrangedList);
	    }

	    // (E) 최종 결과 확인 (디버그 용도)
	    for (int i = 0; i < finalArrangedContainers.size(); i++) {
	        List<Map<String, Object>> portContainerList = finalArrangedContainers.get(i);
	        System.out.println("Port index " + i + " Container Count: " + portContainerList.size());
	        System.out.println("Container Data: " + portContainerList);
	    }
	}

}
