package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.ContainerVO;
import com.example.demo.service.ContainerRecommendationService;

@RestController
@RequestMapping("/testContainer")
public class ContainerRecommendationController {
	
	@Autowired
	private ContainerRecommendationService containerService;
	
	@GetMapping
	public void getContainerRecommendation() {
		List<ContainerVO> containers = Arrays.asList(
				new ContainerVO("C1", "Busan", 16.4, 1),
			    new ContainerVO("C2", "Shanghai", 10.6, 2),
			    new ContainerVO("C3", "Singapore", 24.2, 1),
			    new ContainerVO("C4", "Rotterdam", 13.1, 2),
			    new ContainerVO("C5", "Los Angeles", 20.0, 1),
			    new ContainerVO("C6", "Busan", 13.7, 2),
			    new ContainerVO("C7", "Shanghai", 20.6, 1),
			    new ContainerVO("C8", "Singapore", 14.3, 2),
			    new ContainerVO("C9", "Rotterdam", 19.7, 1),
			    new ContainerVO("C10", "Los Angeles", 9.3, 2),
			    new ContainerVO("C11", "Busan", 11.9, 1),
			    new ContainerVO("C12", "Shanghai", 16.6, 2),
			    new ContainerVO("C13", "Singapore", 16.7, 1),
			    new ContainerVO("C14", "Rotterdam", 9.6, 2),
			    new ContainerVO("C15", "Los Angeles", 22.4, 1),
			    new ContainerVO("C16", "Busan", 13.5, 2),
			    new ContainerVO("C17", "Shanghai", 15.5, 1),
			    new ContainerVO("C18", "Singapore", 13.2, 2),
			    new ContainerVO("C19", "Rotterdam", 24.8, 1),
			    new ContainerVO("C20", "Los Angeles", 14.3, 2),
			    new ContainerVO("C21", "Busan", 22.5, 1),
			    new ContainerVO("C22", "Shanghai", 10.6, 2),
			    new ContainerVO("C23", "Singapore", 23.4, 1),
			    new ContainerVO("C24", "Rotterdam", 13.7, 2),
			    new ContainerVO("C25", "Los Angeles", 16.4, 1),
			    new ContainerVO("C26", "Busan", 16.9, 2),
			    new ContainerVO("C27", "Shanghai", 22.8, 1),
			    new ContainerVO("C28", "Singapore", 15.6, 2),
			    new ContainerVO("C29", "Rotterdam", 15.6, 1),
			    new ContainerVO("C30", "Los Angeles", 13.1, 2),
			    new ContainerVO("C31", "Busan", 10.3, 1),
			    new ContainerVO("C32", "Shanghai", 15.4, 2),
			    new ContainerVO("C33", "Singapore", 19.5, 1),
			    new ContainerVO("C34", "Rotterdam", 13.3, 2),
			    new ContainerVO("C35", "Los Angeles", 23.1, 1),
			    new ContainerVO("C36", "Busan", 14.5, 2),
			    new ContainerVO("C37", "Shanghai", 18.6, 1),
			    new ContainerVO("C38", "Singapore", 9.9, 2),
			    new ContainerVO("C39", "Rotterdam", 23.0, 1),
			    new ContainerVO("C40", "Los Angeles", 12.8, 2),
			    new ContainerVO("C41", "Busan", 7.4, 1),
			    new ContainerVO("C42", "Shanghai", 13.0, 2),
			    new ContainerVO("C43", "Singapore", 23.7, 1),
			    new ContainerVO("C44", "Rotterdam", 16.8, 2),
			    new ContainerVO("C45", "Los Angeles", 17.9, 1),
			    new ContainerVO("C46", "Busan", 16.7, 2),
			    new ContainerVO("C47", "Shanghai", 23.5, 1),
			    new ContainerVO("C48", "Singapore", 16.1, 2),
			    new ContainerVO("C49", "Rotterdam", 18.6, 1),
			    new ContainerVO("C50", "Los Angeles", 10.7, 2),
			    new ContainerVO("C51", "Busan", 19.2, 1),
			    new ContainerVO("C52", "Shanghai", 16.6, 2),
			    new ContainerVO("C53", "Singapore", 16.1, 1),
			    new ContainerVO("C54", "Rotterdam", 9.2, 2),
			    new ContainerVO("C55", "Los Angeles", 23.7, 1),
			    new ContainerVO("C56", "Busan", 10.2, 2),
			    new ContainerVO("C57", "Shanghai", 17.8, 1),
			    new ContainerVO("C58", "Singapore", 12.3, 2),
			    new ContainerVO("C59", "Rotterdam", 22.0, 1),
			    new ContainerVO("C60", "Los Angeles", 14.7, 2),
			    new ContainerVO("C61", "Busan", 16.7, 1),
			    new ContainerVO("C62", "Shanghai", 13.1, 2),
			    new ContainerVO("C63", "Singapore", 22.5, 1),
			    new ContainerVO("C64", "Rotterdam", 12.3, 2),
			    new ContainerVO("C65", "Los Angeles", 19.7, 1),
			    new ContainerVO("C66", "Busan", 8.2, 2),
			    new ContainerVO("C67", "Shanghai", 22.5, 1),
			    new ContainerVO("C68", "Singapore", 15.0, 2),
			    new ContainerVO("C69", "Rotterdam", 16.8, 1),
			    new ContainerVO("C70", "Los Angeles", 11.8, 2),
			    new ContainerVO("C71", "Busan", 14.3, 1),
			    new ContainerVO("C72", "Shanghai", 16.8, 2),
			    new ContainerVO("C73", "Singapore", 17.9, 1),
			    new ContainerVO("C74", "Rotterdam", 8.8, 2),
			    new ContainerVO("C75", "Los Angeles", 21.3, 1),
			    new ContainerVO("C76", "Busan", 25.1, 2),
			    new ContainerVO("C77", "Shanghai", 16.3, 1),
			    new ContainerVO("C78", "Singapore", 13.5, 2),
			    new ContainerVO("C79", "Rotterdam", 20.3, 1),
			    new ContainerVO("C80", "Los Angeles", 16.8, 2),
			    new ContainerVO("C81", "Busan", 12.4, 1),
			    new ContainerVO("C82", "Shanghai", 12.6, 2),
			    new ContainerVO("C83", "Singapore", 21.7, 1),
			    new ContainerVO("C84", "Rotterdam", 12.8, 2),
			    new ContainerVO("C85", "Los Angeles", 18.5, 1),
			    new ContainerVO("C86", "Busan", 25.8, 2),
			    new ContainerVO("C87", "Shanghai", 24.6, 1),
			    new ContainerVO("C88", "Singapore", 14.6, 2),
			    new ContainerVO("C89", "Rotterdam", 19.6, 1),
			    new ContainerVO("C90", "Los Angeles", 8.9, 2),
			    new ContainerVO("C91", "Busan", 13.8, 1),
			    new ContainerVO("C92", "Shanghai", 12.7, 2),
			    new ContainerVO("C93", "Singapore", 18.0, 1),
			    new ContainerVO("C94", "Rotterdam", 12.2, 2),
			    new ContainerVO("C95", "Los Angeles", 20.7, 1),
			    new ContainerVO("C96", "Busan", 12.9, 2),
			    new ContainerVO("C97", "Shanghai", 16.4, 1),
			    new ContainerVO("C98", "Singapore", 10.3, 2),
			    new ContainerVO("C99", "Rotterdam", 21.6, 1),
			    new ContainerVO("C100", "Los Angeles", 13.8, 2),
			    new ContainerVO("C101", "Busan", 11.6, 1),
			    new ContainerVO("C102", "Shanghai", 13.1, 2),
			    new ContainerVO("C103", "Singapore", 22.0, 1),
			    new ContainerVO("C104", "Rotterdam", 14.6, 2),
			    new ContainerVO("C105", "Los Angeles", 17.0, 1),
			    new ContainerVO("C106", "Busan", 10.0, 2),
			    new ContainerVO("C107", "Shanghai", 22.9, 1),
			    new ContainerVO("C108", "Singapore", 12.4, 2),
			    new ContainerVO("C109", "Rotterdam", 15.9, 1),
			    new ContainerVO("C110", "Los Angeles", 12.5, 2),
			    new ContainerVO("C111", "Busan", 19.5, 1),
			    new ContainerVO("C112", "Shanghai", 14.6, 2),
			    new ContainerVO("C113", "Singapore", 19.9, 1),
			    new ContainerVO("C114", "Rotterdam", 9.5, 2),
			    new ContainerVO("C115", "Los Angeles", 24.3, 1),
			    new ContainerVO("C116", "Busan", 23.6, 2),
			    new ContainerVO("C117", "Shanghai", 19.1, 1),
			    new ContainerVO("C118", "Singapore", 11.2, 2),
			    new ContainerVO("C119", "Rotterdam", 21.3, 1),
			    new ContainerVO("C120", "Los Angeles", 14.4, 2),
			    new ContainerVO("C121", "Busan", 22.8, 1),
			    new ContainerVO("C122", "Shanghai", 9.7, 2),
			    new ContainerVO("C123", "Singapore", 22.3, 1),
			    new ContainerVO("C124", "Rotterdam", 17.0, 2),
			    new ContainerVO("C125", "Los Angeles", 16.9, 1),
			    new ContainerVO("C126", "Busan", 21.6, 2),
			    new ContainerVO("C127", "Shanghai", 20.5, 1),
			    new ContainerVO("C128", "Singapore", 14.9, 2),
			    new ContainerVO("C129", "Rotterdam", 18.3, 1),
			    new ContainerVO("C130", "Los Angeles", 12.6, 2),
			    new ContainerVO("C131", "Busan", 28.1, 1),
			    new ContainerVO("C132", "Shanghai", 15.7, 2),
			    new ContainerVO("C133", "Singapore", 19.2, 1),
			    new ContainerVO("C134", "Rotterdam", 13.6, 2),
			    new ContainerVO("C135", "Los Angeles", 22.7, 1),
			    new ContainerVO("C136", "Busan", 29.0, 2),
			    new ContainerVO("C137", "Shanghai", 19.7, 1),
			    new ContainerVO("C138", "Singapore", 11.5, 2),
			    new ContainerVO("C139", "Rotterdam", 24.6, 1),
			    new ContainerVO("C140", "Los Angeles", 16.0, 2),
			    new ContainerVO("C141", "Busan", 6.0, 1),
			    new ContainerVO("C142", "Shanghai", 9.9, 2),
			    new ContainerVO("C143", "Singapore", 25.1, 1),
			    new ContainerVO("C144", "Rotterdam", 13.3, 2),
			    new ContainerVO("C145", "Los Angeles", 19.5, 1),
			    new ContainerVO("C146", "Busan", 29.2, 2),
			    new ContainerVO("C147", "Shanghai", 25.0, 1),
			    new ContainerVO("C148", "Singapore", 16.3, 2),
			    new ContainerVO("C149", "Rotterdam", 18.7, 1),
			    new ContainerVO("C150", "Los Angeles", 11.2, 2),
			    new ContainerVO("C151", "Busan", 13.1, 1),
			    new ContainerVO("C152", "Shanghai", 13.1, 2),
			    new ContainerVO("C153", "Singapore", 18.5, 1),
			    new ContainerVO("C154", "Rotterdam", 9.9, 2),
			    new ContainerVO("C155", "Los Angeles", 24.1, 1),
			    new ContainerVO("C156", "Busan", 19.4, 2),
			    new ContainerVO("C157", "Shanghai", 16.2, 1),
			    new ContainerVO("C158", "Singapore", 11.9, 2),
			    new ContainerVO("C159", "Rotterdam", 22.2, 1),
			    new ContainerVO("C160", "Los Angeles", 13.4, 2),
			    new ContainerVO("C161", "Busan", 17.4, 1),
			    new ContainerVO("C162", "Shanghai", 10.4, 2),
			    new ContainerVO("C163", "Singapore", 21.6, 1),
			    new ContainerVO("C164", "Rotterdam", 14.1, 2),
			    new ContainerVO("C165", "Los Angeles", 15.6, 1),
			    new ContainerVO("C166", "Busan", 26.3, 2),
			    new ContainerVO("C167", "Shanghai", 25.0, 1),
			    new ContainerVO("C168", "Singapore", 14.0, 2),
			    new ContainerVO("C169", "Rotterdam", 16.5, 1),
			    new ContainerVO("C170", "Los Angeles", 12.7, 2),
			    new ContainerVO("C171", "Busan", 23.3, 1),
			    new ContainerVO("C172", "Shanghai", 15.3, 2),
			    new ContainerVO("C173", "Singapore", 17.7, 1),
			    new ContainerVO("C174", "Rotterdam", 13.1, 2),
			    new ContainerVO("C175", "Los Angeles", 21.6, 1),
			    new ContainerVO("C176", "Busan", 10.8, 2),
			    new ContainerVO("C177", "Shanghai", 16.6, 1),
			    new ContainerVO("C178", "Singapore", 9.4, 2),
			    new ContainerVO("C179", "Rotterdam", 21.7, 1),
			    new ContainerVO("C180", "Los Angeles", 17.0, 2),
			    new ContainerVO("C181", "Busan", 27.8, 1),
			    new ContainerVO("C182", "Shanghai", 13.1, 2),
			    new ContainerVO("C183", "Singapore", 22.1, 1),
			    new ContainerVO("C184", "Rotterdam", 14.0, 2),
			    new ContainerVO("C185", "Los Angeles", 16.6, 1),
			    new ContainerVO("C186", "Busan", 8.7, 2),
			    new ContainerVO("C187", "Shanghai", 21.8, 1),
			    new ContainerVO("C188", "Singapore", 16.0, 2),
			    new ContainerVO("C189", "Rotterdam", 17.0, 1),
			    new ContainerVO("C190", "Los Angeles", 9.8, 2),
			    new ContainerVO("C191", "Busan", 23.3, 1),
			    new ContainerVO("C192", "Shanghai", 15.7, 2),
			    new ContainerVO("C193", "Singapore", 17.3, 1),
			    new ContainerVO("C194", "Rotterdam", 9.5, 2),
			    new ContainerVO("C195", "Los Angeles", 22.8, 1),
			    new ContainerVO("C196", "Busan", 26.9, 2),
			    new ContainerVO("C197", "Shanghai", 15.8, 1),
			    new ContainerVO("C198", "Singapore", 11.8, 2),
			    new ContainerVO("C199", "Rotterdam", 24.4, 1),
			    new ContainerVO("C200", "Los Angeles", 13.8, 2),
			    new ContainerVO("C201", "Busan", 29.0, 1),
			    new ContainerVO("C202", "Shanghai", 10.4, 2),
			    new ContainerVO("C203", "Singapore", 23.3, 1),
			    new ContainerVO("C204", "Rotterdam", 12.9, 2),
			    new ContainerVO("C205", "Los Angeles", 19.1, 1),
			    new ContainerVO("C206", "Busan", 27.3, 2),
			    new ContainerVO("C207", "Shanghai", 21.1, 1),
			    new ContainerVO("C208", "Singapore", 14.9, 2),
			    new ContainerVO("C209", "Rotterdam", 18.5, 1),
			    new ContainerVO("C210", "Los Angeles", 13.5, 2),
			    new ContainerVO("C211", "Busan", 17.4, 1),
			    new ContainerVO("C212", "Shanghai", 12.9, 2),
			    new ContainerVO("C213", "Singapore", 20.0, 1),
			    new ContainerVO("C214", "Rotterdam", 10.7, 2),
			    new ContainerVO("C215", "Los Angeles", 23.7, 1),
			    new ContainerVO("C216", "Busan", 6.8, 2),
			    new ContainerVO("C217", "Shanghai", 19.1, 1),
			    new ContainerVO("C218", "Singapore", 12.9, 2),
			    new ContainerVO("C219", "Rotterdam", 21.3, 1),
			    new ContainerVO("C220", "Los Angeles", 15.1, 2),
			    new ContainerVO("C221", "Busan", 29.5, 1),
			    new ContainerVO("C222", "Shanghai", 12.5, 2),
			    new ContainerVO("C223", "Singapore", 22.3, 1),
			    new ContainerVO("C224", "Rotterdam", 15.7, 2),
			    new ContainerVO("C225", "Los Angeles", 19.6, 1),
			    new ContainerVO("C226", "Busan", 27.1, 2),
			    new ContainerVO("C227", "Shanghai", 24.3, 1),
			    new ContainerVO("C228", "Singapore", 16.9, 2),
			    new ContainerVO("C229", "Rotterdam", 16.3, 1),
			    new ContainerVO("C230", "Los Angeles", 10.0, 2),
			    new ContainerVO("C231", "Busan", 20.8, 1),
			    new ContainerVO("C232", "Shanghai", 16.5, 2),
			    new ContainerVO("C233", "Singapore", 20.0, 1),
			    new ContainerVO("C234", "Rotterdam", 11.9, 2),
			    new ContainerVO("C235", "Los Angeles", 22.6, 1),
			    new ContainerVO("C236", "Busan", 11.0, 2),
			    new ContainerVO("C237", "Shanghai", 17.8, 1),
			    new ContainerVO("C238", "Singapore", 12.6, 2),
			    new ContainerVO("C239", "Rotterdam", 22.9, 1),
			    new ContainerVO("C240", "Los Angeles", 14.5, 2),
			    new ContainerVO("C241", "Busan", 21.3, 1),
			    new ContainerVO("C242", "Shanghai", 8.8, 2),
			    new ContainerVO("C243", "Singapore", 24.6, 1),
			    new ContainerVO("C244", "Rotterdam", 13.3, 2),
			    new ContainerVO("C245", "Los Angeles", 15.8, 1),
			    new ContainerVO("C246", "Busan", 18.8, 2),
			    new ContainerVO("C247", "Shanghai", 23.1, 1),
			    new ContainerVO("C248", "Singapore", 16.9, 2),
			    new ContainerVO("C249", "Rotterdam", 17.4, 1),
			    new ContainerVO("C250", "Los Angeles", 12.4, 2),
			    new ContainerVO("C251", "Busan", 21.7, 1),
			    new ContainerVO("C252", "Shanghai", 14.0, 2),
			    new ContainerVO("C253", "Singapore", 18.2, 1),
			    new ContainerVO("C254", "Rotterdam", 13.0, 2),
			    new ContainerVO("C255", "Los Angeles", 20.4, 1),
			    new ContainerVO("C256", "Busan", 7.2, 2),
			    new ContainerVO("C257", "Shanghai", 16.8, 1),
			    new ContainerVO("C258", "Singapore", 11.0, 2),
			    new ContainerVO("C259", "Rotterdam", 20.8, 1),
			    new ContainerVO("C260", "Los Angeles", 14.6, 2),
			    new ContainerVO("C261", "Busan", 23.8, 1),
			    new ContainerVO("C262", "Shanghai", 9.7, 2),
			    new ContainerVO("C263", "Singapore", 22.7, 1),
			    new ContainerVO("C264", "Rotterdam", 13.0, 2),
			    new ContainerVO("C265", "Los Angeles", 16.3, 1),
			    new ContainerVO("C266", "Busan", 26.3, 2),
			    new ContainerVO("C267", "Shanghai", 23.8, 1),
			    new ContainerVO("C268", "Singapore", 16.3, 2),
			    new ContainerVO("C269", "Rotterdam", 19.1, 1),
			    new ContainerVO("C270", "Los Angeles", 13.4, 2),
			    new ContainerVO("C271", "Busan", 22.3, 1),
			    new ContainerVO("C272", "Shanghai", 12.9, 2),
			    new ContainerVO("C273", "Singapore", 19.0, 1),
			    new ContainerVO("C274", "Rotterdam", 13.4, 2),
			    new ContainerVO("C275", "Los Angeles", 24.5, 1),
			    new ContainerVO("C276", "Busan", 20.6, 2),
			    new ContainerVO("C277", "Shanghai", 17.1, 1),
			    new ContainerVO("C278", "Singapore", 9.4, 2),
			    new ContainerVO("C279", "Rotterdam", 21.5, 1),
			    new ContainerVO("C280", "Los Angeles", 13.4, 2),
			    new ContainerVO("C281", "Busan", 25.5, 1),
			    new ContainerVO("C282", "Shanghai", 9.9, 2),
			    new ContainerVO("C283", "Singapore", 20.5, 1),
			    new ContainerVO("C284", "Rotterdam", 13.3, 2),
			    new ContainerVO("C285", "Los Angeles", 16.9, 1),
			    new ContainerVO("C286", "Busan", 19.3, 2),
			    new ContainerVO("C287", "Shanghai", 21.7, 1),
			    new ContainerVO("C288", "Singapore", 13.6, 2),
			    new ContainerVO("C289", "Rotterdam", 15.8, 1),
			    new ContainerVO("C290", "Los Angeles", 10.0, 2),
			    new ContainerVO("C291", "Busan", 27.3, 1),
			    new ContainerVO("C292", "Shanghai", 13.4, 2),
			    new ContainerVO("C293", "Singapore", 18.3, 1),
			    new ContainerVO("C294", "Rotterdam", 11.5, 2),
			    new ContainerVO("C295", "Los Angeles", 23.0, 1),
			    new ContainerVO("C296", "Busan", 10.7, 2),
			    new ContainerVO("C297", "Shanghai", 17.0, 1),
			    new ContainerVO("C298", "Singapore", 9.0, 2),
			    new ContainerVO("C299", "Rotterdam", 21.0, 1),
			    new ContainerVO("C300", "Los Angeles", 15.7, 2),
			    new ContainerVO("C301", "Busan", 18.4, 1),
			    new ContainerVO("C302", "Shanghai", 11.1, 2),
			    new ContainerVO("C303", "Singapore", 20.4, 1),
			    new ContainerVO("C304", "Rotterdam", 15.2, 2),
			    new ContainerVO("C305", "Los Angeles", 19.8, 1),
			    new ContainerVO("C306", "Busan", 27.3, 2),
			    new ContainerVO("C307", "Shanghai", 21.5, 1),
			    new ContainerVO("C308", "Singapore", 12.5, 2),
			    new ContainerVO("C309", "Rotterdam", 17.3, 1),
			    new ContainerVO("C310", "Los Angeles", 13.1, 2),
			    new ContainerVO("C311", "Busan", 10.6, 1),
			    new ContainerVO("C312", "Shanghai", 16.1, 2),
			    new ContainerVO("C313", "Singapore", 17.6, 1),
			    new ContainerVO("C314", "Rotterdam", 10.1, 2),
			    new ContainerVO("C315", "Los Angeles", 22.8, 1),
			    new ContainerVO("C316", "Busan", 29.7, 2),
			    new ContainerVO("C317", "Shanghai", 18.8, 1),
			    new ContainerVO("C318", "Singapore", 10.6, 2),
			    new ContainerVO("C319", "Rotterdam", 21.2, 1),
			    new ContainerVO("C320", "Los Angeles", 13.1, 2),
			    new ContainerVO("C321", "Busan", 14.6, 1),
			    new ContainerVO("C322", "Shanghai", 13.2, 2),
			    new ContainerVO("C323", "Singapore", 24.2, 1),
			    new ContainerVO("C324", "Rotterdam", 17.0, 2),
			    new ContainerVO("C325", "Los Angeles", 19.6, 1),
			    new ContainerVO("C326", "Busan", 23.1, 2),
			    new ContainerVO("C327", "Shanghai", 22.6, 1),
			    new ContainerVO("C328", "Singapore", 13.3, 2),
			    new ContainerVO("C329", "Rotterdam", 16.8, 1),
			    new ContainerVO("C330", "Los Angeles", 9.4, 2),
			    new ContainerVO("C331", "Busan", 18.3, 1),
			    new ContainerVO("C332", "Shanghai", 12.9, 2),
			    new ContainerVO("C333", "Singapore", 20.1, 1),
			    new ContainerVO("C334", "Rotterdam", 10.7, 2),
			    new ContainerVO("C335", "Los Angeles", 22.4, 1),
			    new ContainerVO("C336", "Busan", 16.6, 2),
			    new ContainerVO("C337", "Shanghai", 15.7, 1),
			    new ContainerVO("C338", "Singapore", 10.1, 2),
			    new ContainerVO("C339", "Rotterdam", 23.5, 1),
			    new ContainerVO("C340", "Los Angeles", 13.4, 2),
			    new ContainerVO("C341", "Busan", 19.7, 1),
			    new ContainerVO("C342", "Shanghai", 13.0, 2),
			    new ContainerVO("C343", "Singapore", 24.3, 1),
			    new ContainerVO("C344", "Rotterdam", 12.2, 2),
			    new ContainerVO("C345", "Los Angeles", 16.9, 1),
			    new ContainerVO("C346", "Busan", 19.1, 2),
			    new ContainerVO("C347", "Shanghai", 20.1, 1),
			    new ContainerVO("C348", "Singapore", 14.5, 2),
			    new ContainerVO("C349", "Rotterdam", 19.4, 1),
			    new ContainerVO("C350", "Los Angeles", 11.0, 2),
			    new ContainerVO("C351", "Busan", 22.9, 1),
			    new ContainerVO("C352", "Shanghai", 13.9, 2),
			    new ContainerVO("C353", "Singapore", 16.5, 1),
			    new ContainerVO("C354", "Rotterdam", 13.0, 2),
			    new ContainerVO("C355", "Los Angeles", 24.5, 1),
			    new ContainerVO("C356", "Busan", 20.7, 2),
			    new ContainerVO("C357", "Shanghai", 15.8, 1),
			    new ContainerVO("C358", "Singapore", 12.0, 2),
			    new ContainerVO("C359", "Rotterdam", 24.4, 1),
			    new ContainerVO("C360", "Los Angeles", 16.8, 2),
			    new ContainerVO("C361", "Busan", 13.4, 1),
			    new ContainerVO("C362", "Shanghai", 10.1, 2),
			    new ContainerVO("C363", "Singapore", 21.9, 1),
			    new ContainerVO("C364", "Rotterdam", 15.2, 2),
			    new ContainerVO("C365", "Los Angeles", 15.7, 1),
			    new ContainerVO("C366", "Busan", 21.4, 2),
			    new ContainerVO("C367", "Shanghai", 20.1, 1),
			    new ContainerVO("C368", "Singapore", 15.3, 2),
			    new ContainerVO("C369", "Rotterdam", 19.7, 1),
			    new ContainerVO("C370", "Los Angeles", 9.0, 2),
			    new ContainerVO("C371", "Busan", 25.3, 1),
			    new ContainerVO("C372", "Shanghai", 13.8, 2),
			    new ContainerVO("C373", "Singapore", 18.6, 1),
			    new ContainerVO("C374", "Rotterdam", 10.9, 2),
			    new ContainerVO("C375", "Los Angeles", 21.5, 1),
			    new ContainerVO("C376", "Busan", 10.2, 2),
			    new ContainerVO("C377", "Shanghai", 16.5, 1),
			    new ContainerVO("C378", "Singapore", 13.5, 2),
			    new ContainerVO("C379", "Rotterdam", 21.9, 1),
			    new ContainerVO("C380", "Los Angeles", 16.0, 2),
			    new ContainerVO("C381", "Busan", 12.1, 1),
			    new ContainerVO("C382", "Shanghai", 12.3, 2),
			    new ContainerVO("C383", "Singapore", 21.6, 1),
			    new ContainerVO("C384", "Rotterdam", 13.7, 2),
			    new ContainerVO("C385", "Los Angeles", 17.2, 1),
			    new ContainerVO("C386", "Busan", 24.5, 2),
			    new ContainerVO("C387", "Shanghai", 22.5, 1),
			    new ContainerVO("C388", "Singapore", 14.3, 2),
			    new ContainerVO("C389", "Rotterdam", 17.0, 1),
			    new ContainerVO("C390", "Los Angeles", 12.2, 2),
			    new ContainerVO("C391", "Busan", 15.5, 1),
			    new ContainerVO("C392", "Shanghai", 13.4, 2),
			    new ContainerVO("C393", "Singapore", 16.8, 1),
			    new ContainerVO("C394", "Rotterdam", 12.7, 2),
			    new ContainerVO("C395", "Los Angeles", 22.4, 1),
			    new ContainerVO("C396", "Busan", 18.4, 2),
		 	    new ContainerVO("C397", "Shanghai", 18.6, 1),
			    new ContainerVO("C398", "Singapore", 13.6, 2),
			    new ContainerVO("C399", "Rotterdam", 22.3, 1),
			    new ContainerVO("C400", "Los Angeles", 16.5, 2)
	        );

		 
		containerService.getContainerRecommendation(containers);
	}
	
	
	

}
