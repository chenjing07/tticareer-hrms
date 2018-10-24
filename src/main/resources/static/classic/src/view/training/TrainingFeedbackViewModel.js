Ext.define('Admin.view.training.TrainingFeedbackViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.trainingFeedbackViewModel',

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
		trainingFeedbackLists: {type: 'trainingFeedbackGridStore'}
    }
});
