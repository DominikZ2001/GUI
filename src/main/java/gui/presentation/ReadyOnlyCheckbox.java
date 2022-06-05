package gui.presentation;

import com.vaadin.flow.component.checkbox.Checkbox;

public class ReadyOnlyCheckbox extends Checkbox
{
	private static final long serialVersionUID = 3419359574903722286L;

	public ReadyOnlyCheckbox()
	{
		super();
		setReadOnly(true);
	}

	public ReadyOnlyCheckbox(boolean value)
	{
		super();
		setReadOnly(true);
		setValue(value);
	}

}
