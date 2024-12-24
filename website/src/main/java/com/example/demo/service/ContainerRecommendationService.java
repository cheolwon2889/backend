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

	public void getContainerRecommendation(List<ContainerVO> containerList) {
		String route = "Busan,Shanghai,Singapore,Rotterdam,Los Angeles";
	    List<String> routeList = Arrays.asList(route.split(","));

	    // 결과를 저장할 리스트
	    List<List<Map<String, Object>>> result = new ArrayList<>();
	    List<List<Map<String, Object>>> newResult = new ArrayList<>();

	    // 각 포트를 순회
	    for (String port : routeList) {
	        List<Map<String, Object>> portContainers = new ArrayList<>();

	        for (ContainerVO container : containerList) {
	            if (container.getPort().equals(port)) {
	                Map<String, Object> containerInfo = new HashMap<>();
	                containerInfo.put("ID", container.getId());
	                containerInfo.put("Weight", container.getWeight());
	                portContainers.add(containerInfo);
	            }
	        }

	        // 내림차순 정렬 (무게 기준)
	        portContainers.sort((a, b) -> Double.compare((double) b.get("Weight"), (double) a.get("Weight")));

	        result.add(portContainers);
	    }

	    // 초과 데이터 처리 및 부족 데이터 채우기
	    List<Map<String, Object>> carryOver = new ArrayList<>();
	    for (int i = 0; i < result.size(); i++) {
	        // 현재 항구 데이터 + carryOver
	        List<Map<String, Object>> combinedList = new ArrayList<>(carryOver);
	        combinedList.addAll(result.get(i));

	        // carryOver 초기화
	        carryOver.clear();

	        // 부족한 경우 다음 항구 데이터에서 역순으로 추가
	        if (combinedList.size() < 100) {
	            int index = i + 1;
	            while (combinedList.size() < 100 && index < result.size()) {
	                List<Map<String, Object>> nextPortContainers = result.get(index);

	                while (combinedList.size() < 100 && !nextPortContainers.isEmpty()) {
	                    combinedList.add(nextPortContainers.remove(nextPortContainers.size() - 1));
	                }

	                index++;
	            }
	        }

	        // 100개로 제한하고 초과 데이터는 carryOver에 저장
	        if (combinedList.size() > 100) {
	            carryOver.addAll(combinedList.subList(100, combinedList.size()));
	            combinedList = combinedList.subList(0, 100);
	        }

	        // 최종 리스트에 추가 (0인 경우 제외)
	        if (!combinedList.isEmpty()) {
	        	combinedList.sort((a, b) -> Double.compare((double) b.get("Weight"), (double) a.get("Weight")));
	            newResult.add(combinedList);
	        }
	    }
	    // 최종 결과 출력 및 확인
	    for (int i = 0; i < newResult.size(); i++) {
	        String port = routeList.get(i);
	        List<Map<String, Object>> containers = newResult.get(i);

	        System.out.println("Port: " + port);
	        System.out.println("Containers: " + containers.size());
	        System.out.println("Container List: " + containers); // 실제 데이터 출력
	    }

			
			

//		// 결과 출력
//		for (List<Map<String, Object>> portList : result) {
//			System.out.println(portList);
//		}

//	    이게 문제가 아님.

	// 우선 처리해야 할 조건은. 선박에 한층에 몇개를 포용할 수 있는지;
	// 그러면

	// 10x10 배열 생성 및 초기화
//	    Double[][] routesArray = new Double[10][10];
//	    for (int i = 0; i < routesArray.length; i++) {
//	        for (int j = 0; j < routesArray[i].length; j++) {
//	            routesArray[i][j] = 0.0;
//	        }
//	    }

//	    Double[] temp2List = new Double[10];

//	    int startPointer = 0;
//	    int endPointer = .size() -1; 

//	    System.out.println(temp2List);

	// 중앙부터 값 채우기
//	    int centerRow = routesArray.length / 2;
//	    System.out.println(centerRow);
//	    int centerCol = routesArray[0].length / 2;
//	    System.out.println(routes.size() + ": 몇?" );
//	    System.out.println(ContainerList.size()+" : 몇 ??? ");
//	    
//	    for(int r = 0; r < routes.size() ; r++) {
//	    	List<Double> tempRoute = routes.get(r);
//	    	System.out.println("tempRoute 값 : " + tempRoute );
//	    	for(int w = 0; w< tempRoute.size(); w++) {
//	    		//                                  실제 있는 값.
//	    		// routesArray[centerRow][centerCol] = tempRoute.get(w);
//	    		
//	    	    System.out.println("값 : " + tempRoute.get(w) );
//	    	}
//	    }

//	    for (int r = 0; r < routes.size(); r++) {
//	        List<Double> tempRoute = routes.get(r);
//	        int layer = r; // 각 리스트는 다른 레이어로 확장
//	        int currentRow = centerRow;
//	        int currentCol = centerCol;
//
//	        for (int c = 0; c < tempRoute.size(); c++) {
//	            // 현재 값 넣기
//	            routesArray[currentRow][currentCol] = tempRoute.get(c);
//
//	            // 다음 값으로 이동: 레이어 확장
//	            if (currentCol + 1 < routesArray[0].length - layer) {
//	                currentCol++; // 우측 이동
//	            } else if (currentRow + 1 < routesArray.length - layer) {
//	                currentRow++; // 아래 이동
//	            } else if (currentCol - 1 >= layer) {
//	                currentCol--; // 좌측 이동
//	            } else if (currentRow - 1 >= layer) {
//	                currentRow--; // 위로 이동
//	            }
//	        }
//	    }

	// 결과 출력
//	    System.out.println("Routes Array:");
//	    for (Double[] row : routesArray) {
//	        System.out.println(Arrays.toString(row));
//	    }
//
//	    System.out.println("Routes:");
//	    for (List<Double> routePorts : routes) {
//	        System.out.println(routePorts);
//	    }
	}
}
