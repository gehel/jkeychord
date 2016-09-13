package ch.ledcom.jkeychord;

import com.beust.jcommander.IValueValidator;
import com.beust.jcommander.ParameterException;

import java.io.File;

import static java.lang.String.format;

public class ExistingFileValidator implements IValueValidator<File> {
	@Override
	public void validate(String name, File value) throws ParameterException {
		if (value == null) throw new ParameterException(format("Parameter %s cannot be null.", name));
		if (!value.exists()) throw new ParameterException(format("File %s does not exist.", value));
		if (value.isDirectory()) throw new ParameterException(format("File %s is a directory, it should be a file.", value));
	}
}
