import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bancointer {
 
	WebDriver driver;
	@Before
public void setUp() throws Exception {
		
		// codigo para indicar o navegador
		
		System.setProperty("webdriver.chrome.driver",
				"./Driver/chromedriver.exe");
		
		//comando para chamar o driver dentro do before
		
		driver = new ChromeDriver();
		
		// comando para indicar URL
		
		driver.get("https://www.4devs.com.br/gerador_de_pessoas");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#app-wrapper > div.app-input > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > label")).click();
		driver.findElement(By.cssSelector("#bt_gerar_pessoa")).click();
		Thread.sleep(4000);
		String nome = driver.findElement(By.cssSelector("#nome")).getText();
		String celular = driver.findElement(By.cssSelector("#celular")).getText();
		String email = driver.findElement(By.cssSelector("#email")).getText();
		String cpf = driver.findElement(By.cssSelector("#cpf")).getText();
		String datadenascimento = driver.findElement(By.cssSelector("#data_nasc")).getText();
		
		driver.quit();
		
		
		driver = new ChromeDriver();
		driver.get("https://www.bancointer.com.br/");
		//comando para maximizar a tela
		driver.manage().window().maximize();
		//comando para interagir com o elemento
		driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();
		driver.findElement(By.cssSelector("#gatsby-focus-wrapper > div > header > section > div > div > div > div > div.styles__LogoNIcons-sc-1gbjc3e-6.gjJzHM > div.styles__SearchNFlags-sc-1gbjc3e-8.yVPnY > div.styles__ButtonsWrapper-sc-1gbjc3e-9.PKrxs > button:nth-child(1)")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#nome")).sendKeys(nome);
		driver.findElement(By.cssSelector("#celular")).sendKeys(celular);
        driver.findElement(By.cssSelector("#email ")).sendKeys(email);
        driver.findElement(By.cssSelector("#cpf")).sendKeys(cpf);
        driver.findElement(By.cssSelector("#dataNascimento")).sendKeys(datadenascimento);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center > div > div:nth-child(2) > form > div > div:nth-child(6) > div > label")).click();
        driver.findElement(By.cssSelector("body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center > div > div:nth-child(2) > form > div > div.col-12.text-center > button")).click();
		

	
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		
	}

	@Test
	public void test() throws InterruptedException {
		Thread.sleep(3000);
		String texto = driver.findElement(By.cssSelector("body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center.sent > div > p")).getText();
	    System.out.println(texto);
	    assertEquals(texto,"Prontinho! Recebemos os seus dados.");
	}

}
