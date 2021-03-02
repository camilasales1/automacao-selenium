package br.com.automacao.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CadastroTest {

    private CadastroPage paginaDeCadastro;

    @BeforeEach
    public void beforeEach() {
        paginaDeCadastro = new CadastroPage();
    }

    @AfterEach
    public void afterEach() {
        paginaDeCadastro.fechar();
    }

    @Test
    public void deveriaEfetuarCadastroComCamposValidos() {
        paginaDeCadastro.preencheNomeESobrenome("Camila", "Sales");
        paginaDeCadastro.preencheCheckboxERadio();
        paginaDeCadastro.preencheDropdown();
        paginaDeCadastro.preencheSugestoes("teste com Selenium");
        paginaDeCadastro.preencheDadosDaTabela("teste");
        paginaDeCadastro.submeteCadastro();

        Assertions.assertEquals("Camila", paginaDeCadastro.getNomeCadastrado());
    }

    @Test
    public void naoDeveriaEfetuarCadastroComCamposNulos() {
        paginaDeCadastro.preencheNomeESobrenome("", "");
        paginaDeCadastro.preencheCheckboxERadio();
        paginaDeCadastro.preencheDropdown();
        paginaDeCadastro.preencheSugestoes("");
        paginaDeCadastro.preencheDadosDaTabela("");
        paginaDeCadastro.submeteCadastro();

        paginaDeCadastro.recebeAlertaDeCamposObrigatorios();

//        Assertions.assertEquals("Nome eh obrigatorio", paginaDeCadastro.getTextoDeAlerta());
    }

}
