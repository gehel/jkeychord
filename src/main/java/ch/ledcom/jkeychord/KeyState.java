package ch.ledcom.jkeychord;

import com.dgis.input.evdev.InputEvent;
import com.dgis.input.evdev.InputListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

import static com.dgis.input.evdev.EventType.EV_KEY;
import static com.dgis.input.evdev.EventType.EV_SYN;

public class KeyState implements InputListener {

	private static Logger logger = LoggerFactory.getLogger(KeyState.class);

	private final Set<Short> state = new HashSet<>();

	@Override
	public void event(InputEvent e) {
		if (e.getType().equals(EV_SYN)) logger.debug("Key State: {}", state);
		if (!e.getType().equals(EV_KEY)) return;
		if (e.getValue() == 0) state.remove(e.getCode());
		if (e.getValue() == 1) state.add(e.getCode());
	}
}
