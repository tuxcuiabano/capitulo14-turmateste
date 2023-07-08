package br.edu.ficdev;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.ModelAndView;
import br.edu.ficdev.controller.TurmaController;
import br.edu.ficdev.repository.TurmaRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class TurmaTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TurmaRepository turmaRepository;

    @InjectMocks
    private TurmaController turmaController;
    
    @Test
    public void testAddTurma() throws Exception {
      
        // Criando a turma para testar
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/turma")
                .param("nome", "Turma 3")
                .param("numeroAlunos", "40"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        ModelAndView modelAndView = mvcResult.getModelAndView();

        // Verificação
        assertThat(modelAndView).isNotNull();
        assertThat(modelAndView.getViewName()).isEqualTo("add-turma");
        assertThat(modelAndView.getModel()).containsKey("mensagem");
        String mensagem = (String) modelAndView.getModel().get("mensagem");
        assertThat(mensagem).isEqualTo("Salvo com sucesso!");
    
    }

}




