package ch.ledcom.jkeychord;

import com.beust.jcommander.JCommander;
import com.dgis.input.evdev.EventDevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.IOException;

public class JKeyChord {

	private static Logger logger = LoggerFactory.getLogger(JKeyChord.class);

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {

		Configuration configuration = new Configuration();

		JCommander jCommander = new JCommander(configuration, args);
		if (configuration.isHelp()) {
			jCommander.usage();
			System.exit(0);
		}

		logger.debug("Configuration: {}", configuration);

		EventDevice dev = new EventDevice(configuration.getInputDevice());
		dev.grab();

		KeyState keyState = new KeyState();

		dev.addListener(keyState);
		dev.addListener(e -> logger.debug("event: {}", e));
//		final Robot robot = new Robot();
//		dev.addListener(e -> {
//			if (e.getType().equals(EventType.EV_KEY)) {
//				if (e.getValue() == 1) robot.keyPress(KeyEvent.VK_A);
//				if (e.getValue() == 0) robot.keyRelease(KeyEvent.VK_A);
//			}
//		});

		synchronized (JKeyChord.class) {
			JKeyChord.class.wait();
		}
	}

}
