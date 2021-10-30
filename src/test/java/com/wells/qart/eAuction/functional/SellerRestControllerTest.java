package com.wells.qart.eAuction.functional;
import static com.wells.qart.eAuction.testutils.TestUtils.businessTestFile;
import static com.wells.qart.eAuction.testutils.TestUtils.currentTest;
import static com.wells.qart.eAuction.testutils.TestUtils.testReport;
import static com.wells.qart.eAuction.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;
import java.util.List;
import com.wells.qart.eAuction.dto.SellerDto;
import com.wells.qart.eAuction.service.SellerService;
import org.junit.jupiter.api.AfterAll;
//import org.junit.Test;
////import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.wells.qart.eAuction.controller.SellerRestController;
import com.wells.qart.eAuction.testutils.MasterData;
@WebMvcTest(SellerRestController.class)
@AutoConfigureMockMvc
public class SellerRestControllerTest {
@Autowired
private MockMvc mockMvc;
@MockBean
private SellerService sellerService;
@AfterAll
public static void afterAll() {
	testReport();
}
//	@Test
//	public void testRegisterUser() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//		SellerDto savedSellerDto = MasterData.getUserDto();
//		savedSellerDto.setUserId(1L);
//
//		when(this.sellerService.registerUser(sellerDto)).thenReturn(savedSellerDto);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users").content(MasterData.asJsonString(sellerDto))
//				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		yakshaAssert(currentTest(),
//				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedSellerDto)) ? "true"
//						: "false"),
//				businessTestFile);
//
//	}
//
//	@Test
//	public void testRegisterUserIsServiceMethodCalled() throws Exception {
//		final int count[] = new int[1];
//		SellerDto sellerDto = MasterData.getUserDto();
//		SellerDto savedSellerDto = MasterData.getUserDto();
//		savedSellerDto.setUserId(1L);
//		when(sellerService.registerUser(sellerDto)).then(new Answer<SellerDto>() {
//
//			@Override
//			public SellerDto answer(InvocationOnMock invocation) throws Throwable {
//				// TODO Auto-generated method stub
//				count[0]++;
//				return savedSellerDto;
//			}
//		});
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users").content(MasterData.asJsonString(sellerDto))
//				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);
//
//	}
//
//	@Test
//	public void testGetAllUsers() throws Exception {
//		List<SellerDto> users = MasterData.getUserDtoList();
//
//		when(this.sellerService.findAll()).thenReturn(users);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users").contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		yakshaAssert(currentTest(),
//				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(users)) ? "true"
//						: "false"),
//				businessTestFile);
//
//	}
//
//	@Test
//	public void testGetAllUsersIsServiceMethodCalled() throws Exception {
//		final int count[] = new int[1];
//		List<SellerDto> users = MasterData.getUserDtoList();
//		when(this.sellerService.findAll()).then(new Answer<List<SellerDto>>() {
//
//			@Override
//			public List<SellerDto> answer(InvocationOnMock invocation) throws Throwable {
//				// TODO Auto-generated method stub
//				count[0]++;
//				return users;
//			}
//		});
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users").contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);
//
//	}
//
//	@Test
//	public void testDeleteUser() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//        sellerDto.setUserId(1L);
//		when(this.sellerService.deleteUser(1L)).thenReturn(true);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users/1")
//				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		yakshaAssert(currentTest(),
//				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(true)) ? "true"
//						: "false"),
//				businessTestFile);
//
//	}
//
//	@Test
//	public void testDeleteUserIsServiceMethodCalled() throws Exception {
//		final int count[] = new int[1];
//		SellerDto sellerDto = MasterData.getUserDto();
//		when(this.sellerService.deleteUser(sellerDto.getUserId())).then(new Answer<Boolean>() {
//
//			@Override
//			public Boolean answer(InvocationOnMock invocation) throws Throwable {
//				// TODO Auto-generated method stub
//				count[0]++;
//				return true;
//			}
//		});
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users/1")
//				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);
//	}
//
//
//	@Test
//	public void testUpdateUser() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//		SellerDto savedSellerDto = MasterData.getUserDto();
//		savedSellerDto.setUserId(1L);
//
//		when(this.sellerService.updateUser(sellerDto)).thenReturn(savedSellerDto);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/users").content(MasterData.asJsonString(sellerDto))
//				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		yakshaAssert(currentTest(),
//				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedSellerDto)) ? "true"
//						: "false"),
//				businessTestFile);
//
//	}
//
//	@Test
//	public void testUpdateUserIsServiceMethodCalled() throws Exception {
//		final int count[] = new int[1];
//		SellerDto sellerDto = MasterData.getUserDto();
//		SellerDto savedSellerDto = MasterData.getUserDto();
//		savedSellerDto.setUserId(1L);
//		when(sellerService.updateUser(sellerDto)).then(new Answer<SellerDto>() {
//
//			@Override
//			public SellerDto answer(InvocationOnMock invocation) throws Throwable {
//				// TODO Auto-generated method stub
//				count[0]++;
//				return savedSellerDto;
//			}
//		});
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/users").content(MasterData.asJsonString(sellerDto))
//				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);
//
//	}
//
//
}
