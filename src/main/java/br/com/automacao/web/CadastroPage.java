package br.com.automacao.web;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.util.Assert;

import java.awt.*;

public class CadastroPage {

    private static final String URL_CADASTRO = "http://wcaquino.me/cypress/componentes.html";
    private WebDriver browser;

    public CadastroPage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        browser = new ChromeDriver();
        browser.navigate().to(URL_CADASTRO);
    }

    public void fechar() {
        browser.quit();
    }

    public void preencheNomeESobrenome(String nome, String sobrenome) {
        browser.findElement(By.id("formNome")).sendKeys(nome);
        browser.findElement(By.id("formSobrenome")).sendKeys(sobrenome);
    }

    public void preencheCheckboxERadio() {
        browser.findElement(By.id("formSexoFem")).click();
        browser.findElement(By.id("formComidaFrango")).click();
        browser.findElement(By.id("formComidaCarne")).click();
    }

    public void preencheDropdown() {
        Select dropdownEscolaridade = new Select(browser.findElement(By.id("formEscolaridade")));
        dropdownEscolaridade.selectByVisibleText("Superior");

        Select dropdownEsportes = new Select(browser.findElement(By.id("formEsportes")));
        dropdownEsportes.selectByVisibleText("Futebol");
        dropdownEsportes.selectByVisibleText("Karate");
    }

    public void preencheSugestoes(String sugestao) {
        browser.findElement(By.id("elementosForm:sugestoes")).sendKeys(sugestao);

    }

    public void preencheDadosDaTabela(String inputTabela) {
        browser.findElement(By.xpath("/html/body/center/form/table/tbody/tr[8]/td[2]/table/tbody/tr[1]/td[4]/input")).click();
        browser.findElement(By.xpath("/html/body/center/form/table/tbody/tr[8]/td[2]/table/tbody/tr[1]/td[5]/table/tbody/tr/td/input")).click();
        browser.findElement(By.xpath("/html/body/center/form/table/tbody/tr[8]/td[2]/table/tbody/tr[1]/td[6]/input")).sendKeys(inputTabela);

        //Clica no botõa "Clique aqui" que abre um popUp
        browser.findElement(By.xpath("/html/body/center/form/table/tbody/tr[8]/td[2]/table/tbody/tr[1]/td[3]/input")).click();

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
            return browser.findElement(By.cssSelector("#descNome > span:nth-child(1)")).getText();
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
}
