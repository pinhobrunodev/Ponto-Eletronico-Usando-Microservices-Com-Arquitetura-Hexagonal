package com.pinhobrunodev.userms.frameworks.adapters.inbound;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinhobrunodev.userms.application.domain.UserDomain;
import com.pinhobrunodev.userms.application.ports.UserPersistencePort;
import com.pinhobrunodev.userms.application.ports.UserProducerPort;
import com.pinhobrunodev.userms.application.ports.UserServicePort;
import com.pinhobrunodev.userms.application.services.UserServicePortImpl;
import com.pinhobrunodev.userms.frameworks.adapters.dto.UserDto;
import com.pinhobrunodev.userms.tests.Factory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private UserServicePort userServicePort;
    @Mock
    private UserProducerPort userProducerPort;
    @Mock
    private UserPersistencePort userPersistencePort;

    @Autowired
    private ObjectMapper mapper;

    private UserDomain userDomainReturn;

    private UserDto userDto;

    @BeforeEach
    public void setUp() throws Exception {
        userDomainReturn = new UserDomain();
        userDto = Factory.createRightUserDto();
        userServicePort = new UserServicePortImpl(userProducerPort, userPersistencePort);
        Mockito.when(userServicePort.saveUser(ArgumentMatchers.any())).thenReturn(userDomainReturn);
    }

    @Test
    public void insertShouldReturnUserDomainAndHttpStatusCode201() throws Exception {
        String jsonBody = mapper.writeValueAsString(userDto);
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/auth/signup").content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
        result.andExpect(MockMvcResultMatchers.status().isCreated());
        log.info("Body from post {}",jsonBody);
        result.andExpect(MockMvcResultMatchers.jsonPath("$.userId").exists());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").exists());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.lastName").exists());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.email").exists());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.departmentType").exists());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.creationDate").exists());
    }


}
