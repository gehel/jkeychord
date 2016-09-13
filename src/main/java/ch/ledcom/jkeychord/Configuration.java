package ch.ledcom.jkeychord;

import com.beust.jcommander.Parameter;
import lombok.Getter;
import lombok.ToString;

import java.io.File;

@ToString
public class Configuration {

	@Getter
	@Parameter(names = {"-h", "--help"}, help = true)
	private boolean help = false;

	@Getter
	@Parameter(
			names = { "-i", "--input-device" },
			description = "Input device",
			required = true,
			validateValueWith = ExistingFileValidator.class
	)
	private File inputDevice;

}
