package br.com.automacao.web;

import org.fluentlenium.core.annotation.PageUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Elementos {

    private WebDriver browser;

    @PageUrl("http://wcaquino.me/cypress/componentes.html")
    @FindBy(id = "formNome")
    WebElement nomeId;


    public By nome() {
        return new By.ById("formNome");
    }

    public By sobrenome() {
        return new By.ById("formSobrenome");
    }

    public By formGeneroFeminino() {
        return new By.ById("formSexoFem");
    }

    public By formGeneroMasculino() {
        return new By.ById("formSexoMasc");
    }

    public By formComidaCarne() {
        return new By.ById("formComidaCarne");
    }

    public By formComidaFrango() {
        return new By.ById("formComidaFrango");
    }

    public By formComidaPizza() {
        return new By.ById("formComidaPizza");
    }

    public By formComidaVegetariano() {
        return new By.ById("formComidaVegetariana");
    }

    public By formEscolaridade() {
        return new By.ById("formEscolaridade");
    }

    public By formEsportes() {
        return new By.ById("formEsportes");
    }

    public By sugestoes() {
        return new By.ById("elementosForm:sugestoes");
    }

    public By checkboxTabela() {
        return new By.ByCssSelector("#tabelaUsuarios > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(4) > input:nth-child(1)");
    }

    public By radioTabela() {
        return new By.ByCssSelector("#tabelaUsuarios > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(5) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > input:nth-child(1)");
    }

    public By inputTabela() {
        return new By.ByCssSelector("#tabelaUsuarios > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(6) > input:nth-child(1)");
    }

    public By botaoCliqueAqui() {
        return new By.ByCssSelector("html body center form#elementosForm table tbody tr td table#tabelaUsuarios tbody tr td input");
    }

    public By nomeCadastrado() {
        return new By.ByCssSelector("#descNome > span:nth-child(1)");
    }

    public By tituloDaPagina() {
        return new By.ByCssSelector("#elementosForm > h3:nth-child(1)");
    }

    public By tituloNome() {
        return new By.ByCssSelector("#elementosForm > table:nth-child(13) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > label:nth-child(1)");
    }

}

