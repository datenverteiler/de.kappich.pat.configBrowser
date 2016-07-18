/*
 * Copyright 2007 by Kappich Systemberatung, Aachen
 * Copyright 2004 by Kappich+Kniß Systemberatung, Aachen
 * 
 * This file is part of de.kappich.pat.configBrowser.
 * 
 * de.kappich.pat.configBrowser is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * de.kappich.pat.configBrowser is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with de.kappich.pat.configBrowser.  If not, see <http://www.gnu.org/licenses/>.

 * Contact Information:
 * Kappich Systemberatung
 * Martin-Luther-Straße 14
 * 52062 Aachen, Germany
 * phone: +49 241 4090 436 
 * mail: <info@kappich.de>
 */

package de.kappich.pat.configBrowser.main;

import de.bsvrz.dav.daf.main.ClientDavInterface;
import de.bsvrz.dav.daf.main.config.DataModel;
import de.bsvrz.sys.funclib.commandLineArgs.ArgumentList;
import de.bsvrz.sys.funclib.application.StandardApplication;
import de.bsvrz.sys.funclib.application.StandardApplicationRunner;
import de.bsvrz.sys.funclib.debug.Debug;

/**
 * Applikation, die online via Datenverteiler eine Darstellung der Konfigurationsobjekte in einem Swing-Fenster realisiert. 
 * @author Kappich Systemberatung
 * @version $Revision$
 */
public class OnlineConfigurationViewer implements StandardApplication {
	private static Debug _debug;

	public static void main(String[] args) {
		StandardApplicationRunner.run(new OnlineConfigurationViewer(), args);
	}

	public void parseArguments(ArgumentList argumentList) throws Exception {
		_debug = Debug.getLogger();
	}

	public void initialize(ClientDavInterface connection) throws Exception {
		DataModel configuration = connection.getDataModel();
		_debug.fine("Online Konfiguration", configuration);
		DataModelTreePanel.showTreeFrame(configuration);
	}
}
