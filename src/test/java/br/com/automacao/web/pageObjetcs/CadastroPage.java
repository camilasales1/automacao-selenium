package br.com.automacao.web.pageObjetcs;

import br.com.automacao.web.elements.Elementos;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CadastroPage {

    private static final String URL_CADASTRO = "http://wcaquino.me/cypress/componentes.html";
    private WebDriver browser;

    Elementos elementos = new Elementos();

    public CadastroPage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        browser = new ChromeDriver();
        browser.navigate().to(URL_CADASTRO);
        browser.manage().window().maximize();
    }

    public void fechar() {
        browser.quit();
    }

    public void preencheNomeESobrenome(String nome, String sobrenome) {
        browser.findElement(elementos.nome()).sendKeys(nome);
        browser.findElement(elementos.sobrenome()).sendKeys(sobrenome);
    }

    public void preencheCheckboxERadio() {
        browser.findElement(elementos.formGeneroFeminino()).click();
        browser.findElement(elementos.formComidaFrango()).click();
        browser.findElement(elementos.formComidaCarne()).click();

        Assertions.assertTrue(browser.findElement(By.id("formSexoFem")).isSelected());
    }

    public void preencheDropdown() {
        Select dropdownEscolaridade = new Select(browser.findElement(elementos.formEscolaridade()));
        dropdownEscolaridade.selectByVisibleText("Superior");

        Select dropdownEsportes = new Select(browser.findElement(elementos.formEsportes()));
        dropdownEsportes.selectByVisibleText("Futebol");
        dropdownEsportes.selectByVisibleText("Karate");
    }

    public void preencheSugestoes(String sugestao) {
        browser.findElement(elementos.sugestoes()).sendKeys(sugestao);

    }

    public void preencheDadosDaTabela(String inputTabela) {
        browser.findElement(elementos.checkboxTabela()).click();
        browser.findElement(elementos.radioTabela()).click();
        browser.findElement(elementos.inputTabela()).sendKeys(inputTabela);

        //Clica no botõa "Clique aqui" que abre um popUp
        browser.findElement(elementos.botaoCliqueAqui()).click();

        //Fecha o popUp
        Alert alert = browser.switchTo().alert();
        alert.accept();
    }

    public void submeteCadastro() {
        browser.findElement(By.id("formCadastrar")).click();
    }

    public boolean isPaginaDeCadastro() {
        return browser.getCurrentUrl().equals(URL_CADASTRO);
    }

    public String getNomeCadastrado() {
        try {
            return browser.findElement(elementos.nomeCadastrado()).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void recebeAlertaDeCamposObrigatorios() {
        Alert alert = browser.switchTo().alert();
    }

    public String getTextoDeAlerta() {
        Alert alert = browser.switchTo().alert();
        String textoAlerta = alert.getText();
        return textoAlerta;
    }


    public void verificaTitulos() {
        String tituloDaPagina = browser.findElement(elementos.tituloDaPagina()).getText();
        assertEquals("Campo de Treinamento", tituloDaPagina);

        String tituloNome = browser.findElement(elementos.tituloNome()).getText();
        assertEquals("Nome:", tituloNome);
    }

    public void testDefaultCheckbox() {
        assertFalse(browser.findElement(elementos.formGeneroMasculino()).isSelected());
        assertFalse(browser.findElement(elementos.formGeneroFeminino()).isSelected());
        assertFalse(browser.findElement(elementos.formComidaCarne()).isSelected());
        assertFalse(browser.findElement(elementos.formComidaFrango()).isSelected());
        assertFalse(browser.findElement(elementos.formComidaPizza()).isSelected());
        assertFalse(browser.findElement(elementos.formComidaVegetariano()).isSelected());
    }
}
