package pages.PulseSettings;

import org.openqa.selenium.By;

public class ChannelsPage {

	//locators
	By SettingsIcon = By.xpath("//span//img[@alt='Settings']");
	By PulseSettings = By.xpath("//img[@alt='Pulse Settings']//ancestor::button");
	By ChannelsTab = By.xpath("//a[normalize-space()='Channels']");
	By ChatbotChannel = By.xpath("//img[@alt='CHATBOT']//ancestor::div[contains(@class,'cursor-pointer')]");
	
}
