package br.com.automacao.web;

import br.com.automacao.web.pageObjetcs.CadastroPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CadastroTest {

    private CadastroPage paginaDeCadastro;

    @BeforeEach
    public void beforeEach() {
        paginaDeCadastro = new CadastroPage();
        paginaDeCadastro.isPaginaDeCadastro();
    }

    @AfterEach
    public void afterEach() {
        paginaDeCadastro.fechar();
    }

    @Test
    public void validaTituloSDaPagina() {
        paginaDeCadastro.verificaTitulos();
    }

    @Test
    public void osCamposDeveriamEstarDesabilitador() {
        paginaDeCadastro.testDefaultCheckbox();
    }

    @Test
    public void deveriaEfetuarCadastroComCamposValidos() {
        paginaDeCadastro.preencheNomeESobrenome("Camila", "Sales");
        paginaDeCadastro.preencheCheckboxERadio();
        paginaDeCadastro.preencheDropdown();
        paginaDeCadastro.preencheSugestoes("teste com Selenium");
        paginaDeCadastro.preencheDadosDaTabela("teste");
        paginaDeCadastro.submeteCadastro();

        assertEquals("Camila", paginaDeCadastro.getNomeCadastrado());
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

        assertEquals("Nome eh obrigatorio", paginaDeCadastro.getTextoDeAlerta());
    }
}
