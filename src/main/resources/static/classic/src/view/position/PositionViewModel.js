Ext.define('Admin.view.position.PositionViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.positionViewModel',

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
        positionLists: {type: 'positionGridStore'}
    }
});
