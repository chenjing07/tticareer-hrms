Ext.define('Admin.view.authentication.AuthenticationViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.authenticationViewModel',

    requires: [
        'Ext.data.Store',
        'Ext.data.proxy.Memory',
        'Ext.data.field.Integer',
        'Ext.data.field.String',
        'Ext.data.field.Date',
        'Ext.data.field.Boolean',
        'Ext.data.reader.Json'
    ],
    stores: {
    	authenticationLists: {type: 'authenticationStore'}//调用组件2
    }
});