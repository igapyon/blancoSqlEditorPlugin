/*
 * blancoSqlEditorPlugin
 * Copyright (C) 2005 sari
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.plugin.sqleditor;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import blanco.plugin.sqleditor.resourcebundle.BlancoSqlEditorPluginResourceBundle;

/**
 * BlancoSqlEditorプラグインのクラス
 * 
 * @author sari オリジナル版の開発
 * @author Toshiki Iga プラグイン部分の改変
 */
public class BlancoSqlEditorPlugin extends AbstractUIPlugin {
    // The shared instance.
    private static BlancoSqlEditorPlugin plugin;

    // Resource bundle.
    private final BlancoSqlEditorPluginResourceBundle resourceBundle = new BlancoSqlEditorPluginResourceBundle();

    /**
     * The constructor.
     */
    public BlancoSqlEditorPlugin() {
        super();
        plugin = this;
    }

    /**
     * This method is called upon plug-in activation
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
    }

    /**
     * This method is called when the plug-in is stopped
     */
    public void stop(BundleContext context) throws Exception {
        super.stop(context);
    }

    /**
     * Returns the shared instance.
     */
    public static BlancoSqlEditorPlugin getDefault() {
        return plugin;
    }

    /**
     * Returns the plugin's resource bundle,
     */
    public static BlancoSqlEditorPluginResourceBundle getResourceBundle() {
        return getDefault().resourceBundle;
    }
}
