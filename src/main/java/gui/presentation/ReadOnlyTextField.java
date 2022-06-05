package gui.presentation;

import com.vaadin.flow.component.textfield.TextField;

public class ReadOnlyTextField extends TextField
{
	private static final long serialVersionUID = -6071352692024575103L;

	public ReadOnlyTextField()
	{
		super();
		setReadOnly(true);
	}

	public ReadOnlyTextField(String label, String value)
	{
		super();
		setReadOnly(true);
		setValue(value);
		setLabel(label);
	}

}
