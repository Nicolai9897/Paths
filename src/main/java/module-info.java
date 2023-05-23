module no.ntnu.idatg2001.paths {
  requires javafx.controls;
  requires javafx.graphics;
  requires javafx.base;

  exports no.ntnu.idatg2001.paths;
  exports no.ntnu.idatg2001.paths.actions;
  exports no.ntnu.idatg2001.paths.base;
  exports no.ntnu.idatg2001.paths.customExceptions;
  exports no.ntnu.idatg2001.paths.goals;
  exports no.ntnu.idatg2001.paths.ui;
  exports no.ntnu.idatg2001.paths.ui.controllers;
  exports no.ntnu.idatg2001.paths.ui.dialogs;
  exports no.ntnu.idatg2001.paths.ui.scenes;
  exports no.ntnu.idatg2001.paths.utility;
  exports no.ntnu.idatg2001.paths.player;

  opens no.ntnu.idatg2001.paths;
  opens no.ntnu.idatg2001.paths.actions;
  opens no.ntnu.idatg2001.paths.base;
  opens no.ntnu.idatg2001.paths.customExceptions;
  opens no.ntnu.idatg2001.paths.goals;
  opens no.ntnu.idatg2001.paths.ui;
  opens no.ntnu.idatg2001.paths.ui.controllers;
  opens no.ntnu.idatg2001.paths.ui.dialogs;
  opens no.ntnu.idatg2001.paths.ui.scenes;
  opens no.ntnu.idatg2001.paths.utility;
  opens no.ntnu.idatg2001.paths.player;
}