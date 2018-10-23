Ext.define('Admin.view.interview.InterviewViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.interviewViewModel',

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
        interviewLists: {type: 'interviewStore'}
    }
});
