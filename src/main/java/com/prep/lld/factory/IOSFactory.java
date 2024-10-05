package com.prep.lld.factory;

import com.prep.lld.factory.ios.IOSButton;
import com.prep.lld.factory.ios.IOSPanel;
import com.prep.lld.factory.ios.IOSTextBox;
import com.prep.lld.factory.ui.Button;
import com.prep.lld.factory.ui.Panel;
import com.prep.lld.factory.ui.TextBox;

/**
 * IOSFactory
 */
public class IOSFactory implements UIFactory {

  @Override
  public Button createButton() {
    // TODO Auto-generated method stub
    return new IOSButton();
  }

  @Override
  public Panel createPanel() {
    // TODO Auto-generated method stub
    return new IOSPanel();
  }

  @Override
  public TextBox createTextBox() {
    // TODO Auto-generated method stub
    return new IOSTextBox();
  }

}
