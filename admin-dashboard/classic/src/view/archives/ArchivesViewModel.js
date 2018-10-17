Ext.define('Admin.view.archives.ArchivesViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.archivesViewModel',

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
        archivesLists: {type: 'archivesGridStore'}
    }
});
