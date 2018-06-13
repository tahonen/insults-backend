package com.tahonen.ocp.demos.insults;

import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Stateless;

import org.apache.commons.io.IOUtils;

@Stateless
@Startup
public class InsultsRepo {
	public static final String LONG_ADJECTIVES_FILE = "/long-adjectives.txt";
	public static final String SHORT_ADJECTIVES_FILE = "/short-adjectives.txt";
	public static final String NOUNS_FILE = "/nouns.txt";
	
	private List<String> longAdjectives;
	private List<String> shortAdjectives;
	private List<String> nouns;

	public String[] getInsult(){
		String[] insult = new String[3];
		insult[0] = shortAdjectives.get(ThreadLocalRandom.current().nextInt(0, shortAdjectives.size()));
		insult[1] = longAdjectives.get(ThreadLocalRandom.current().nextInt(0, longAdjectives.size()));
		insult[2] = nouns.get(ThreadLocalRandom.current().nextInt(0, nouns.size()));
		return insult;
	}
	
	@PostConstruct
	private void init() {
		try {
			longAdjectives = IOUtils.readLines(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(LONG_ADJECTIVES_FILE)));
			shortAdjectives = IOUtils.readLines(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(SHORT_ADJECTIVES_FILE)));
			nouns = IOUtils.readLines(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(NOUNS_FILE)));
		} catch (Exception e) {
			e.printStackTrace();
			longAdjectives = new ArrayList<String>();
			longAdjectives.add("Application ");
			shortAdjectives = new ArrayList<String>();
			shortAdjectives.add("initialization ");
			nouns = new ArrayList<String>();
			nouns.add("failed.");
		}

	}
}
