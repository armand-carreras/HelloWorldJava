package com.netmind.presentation;

import java.util.HashMap;
import java.util.Map;

public enum OptionMenu {
	ADD(1), OLDEST(2), AVERAGE(3), EXIT(4);

	private int value;
	private static Map map = new HashMap<>();

	private OptionMenu(int value) {
		this.value = value;
	}

	static {
		for (OptionMenu optionMenu : OptionMenu.values()) {
			map.put(optionMenu.value, optionMenu);
		}
	}

	public static OptionMenu valueOf(int optionMenu) {
		return (OptionMenu) map.get(optionMenu);
	}

	public int getValue() {
		return value;
	}
}
