package com.prep.lld.factory;

import com.prep.lld.factory.ui.Button;
import com.prep.lld.factory.ui.Panel;
import com.prep.lld.factory.ui.TextBox;

/**
 * UIFactory
 */
public interface UIFactory {

  Button createButton();

  TextBox createTextBox();

  Panel createPanel();
}
