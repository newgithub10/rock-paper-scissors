package com.mcnz.translator;

import com.ibm.watson.developer_cloud.language_translator.v3.LanguageTranslator;
import com.ibm.watson.developer_cloud.language_translator.v3.model.TranslateOptions;
import com.ibm.watson.developer_cloud.language_translator.v3.model.TranslationResult;
import com.ibm.watson.developer_cloud.service.security.IamOptions;

public class WatsonTranslator {
	
	
	public static String VERSION = "2018-05-01";
	public static String END_POINT = "https://gateway-wdc.watsonplatform.net/language-translator/api";
	public static String API_KEY = "qSLnjJqK7rhgiuNCzmr1Zdflp4AuE6Q95kEgn5dKddrK";
	
	public static LanguageTranslator getLanguageTranslator() {
		
		IamOptions options = new IamOptions.Builder().apiKey(API_KEY).build();
		LanguageTranslator languageTranslator = new LanguageTranslator(VERSION, options);
		languageTranslator.setEndPoint(END_POINT);
		return languageTranslator;
		
	}
	
	public static String translate(String text, String languageModel) {

		TranslateOptions translateOptions = new TranslateOptions.Builder().addText(text).modelId(languageModel).build();
		TranslationResult result = getLanguageTranslator() .translate(translateOptions).execute();
		result.getTranslations().get(0);
		System.out.println(result.getTranslations().get(0));
		return result.getTranslations().get(0).getTranslationOutput();
	}
	
	
	public static void main(String args[]) {
		System.out.println(WatsonTranslator.translate("Christmas", "en-fr"));
	}
	

}
