package com.theironyard;

import com.theironyard.entities.Recipe;
import com.theironyard.services.GuildWarsApiService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestGuildWarsApiService {


    @Autowired
    WebApplicationContext wap;

    @Autowired
    GuildWarsApiService guildWars;

    MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wap).build();
    }

    @Test
    public void testGetRecipeById() {
        String id = "100";
        String recipeType = "Insignia";
        Integer outputItemId = 19855;
        Integer ingredientOneId = 72194;
        Integer ingredientOneCount = 1;
        Integer ingredientTwoId = 24294;
        Integer ingredientTwoCount = 8;

        Recipe recipe = guildWars.getRecipeById(id);
    }
}
