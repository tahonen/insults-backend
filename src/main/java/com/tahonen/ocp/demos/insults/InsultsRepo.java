package com.tahonen.ocp.demos.insults;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Stateful;

import org.apache.commons.io.FileUtils;

@Stateful
@Startup
public class InsultsRepo {
	public static final String LONG_ADJECTIVES_FILE = "long-adjectives.txt";
	public static final String SHORT_ADJECTIVES_FILE = "short-adjectives.txt";
	public static final String NOUNS_FILE = "nouns.txt";
	
	private List<String> longAdjectives;
	private List<String> shortAdjectives;
	private List<String> nouns;

	public String[] getInsult(){
		String[] insult = new String[3];
		insult[0] = longAdjectives.get(ThreadLocalRandom.current().nextInt(0, longAdjectives.size() + 1));
		insult[1] = shortAdjectives.get(ThreadLocalRandom.current().nextInt(0, shortAdjectives.size() + 1));
		insult[2] = nouns.get(ThreadLocalRandom.current().nextInt(0, nouns.size() + 1));
		return insult;
	}
	
	@PostConstruct
	private void init() {
		try {
			File file = new File(LONG_ADJECTIVES_FILE);
			longAdjectives = FileUtils.readLines(file, "UTF-8");
			file = new File(SHORT_ADJECTIVES_FILE);
			shortAdjectives = FileUtils.readLines(file, "UTF-8");
			file = new File(NOUNS_FILE);
			nouns = FileUtils.readLines(file, "UTF-8");
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
