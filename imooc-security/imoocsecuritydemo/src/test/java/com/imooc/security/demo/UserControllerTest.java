package com.imooc.security.demo;

import com.imooc.security.demo.DemoApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * zhshl  2018/9/9
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    @Test
    public void whenQuerySuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user").
                contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("username","jojo")
                .param("ageTo","60")
                .param("age","18")
                .param("xxx","yyy")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.length()")
                        .value(3));
    }
    @Test
    public void whenGetInfoSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                        .contentType(MediaType.APPLICATION_JSON_UTF8) )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("tom"));

    }
    @Test
    public void whenGetInfoFail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/ee")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void whenCreateSuccess() throws Exception {

        Date date = new Date();
        System.out.println(date.getTime());
        String content = "{\"username\":\"tom\",\"password\":null,\"birthday\":"+date.getTime()+"}";
        String reuslt = mockMvc.perform(MockMvcRequestBuilders.post("/user").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andReturn().getResponse().getContentAsString();

        System.out.println(reuslt);
    }
    @Test
    public void whenUpdateSuccess() throws Exception {

        Date date = new Date(LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        System.out.println(date.getTime());
        String content = "{\"id\":\"1\",\"username\":\"\",\"password\":null,\"birthday\":"+date.getTime()+"}";
        String reuslt = mockMvc.perform(MockMvcRequestBuilders.put("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andReturn().getResponse().getContentAsString();

        System.out.println(reuslt);
    }
    @Test
    public void whenDeleteSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8)).
                andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void whenUploadSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/file")
                .file(new MockMultipartFile("file","test.text","mutipart/form-data","hello upload".getBytes("UTF-8"))))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}
