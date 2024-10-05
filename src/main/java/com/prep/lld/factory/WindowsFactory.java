package com.prep.lld.factory;

import com.prep.lld.factory.ui.Button;
import com.prep.lld.factory.ui.Panel;
import com.prep.lld.factory.ui.TextBox;
import com.prep.lld.factory.windows.WindowsButton;
import com.prep.lld.factory.windows.WindowsPanel;
import com.prep.lld.factory.windows.WindowsTextBox;

/**
 * WindowsFactory
 */
public class WindowsFactory implements UIFactory {

  @Override
  public Button createButton() {
    return new WindowsButton();
  }

  @Override
  public Panel createPanel() {
    return new WindowsPanel();
  }

  @Override
  public TextBox createTextBox() {
    return new WindowsTextBox();
  }

}
