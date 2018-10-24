Ext.define('Admin.view.assessment.EmployeeAssessmentViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.employeeAssessmentViewModel',

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
		EmployeeAssessmentLists: {type: 'employeeAssessmentGridStore'},
		EmployeeAssessmentCheckLists: {type: 'employeeAssessmentCheckGridStore'}
    }
});
