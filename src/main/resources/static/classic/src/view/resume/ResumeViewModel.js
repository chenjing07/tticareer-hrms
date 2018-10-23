Ext.define('Admin.view.resume.ResumeViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.resumeViewModel',

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
        resumeLists: {type: 'resumeStore'}
    }
});
