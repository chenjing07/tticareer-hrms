Ext.define('Admin.view.assessment.EmployeeAssessment', {
    extend: 'Ext.container.Container',
    xtype: 'employeeAssessment',
    
    controller: 'employeeAssessmentViewController',
    viewModel: {type: 'employeeAssessmentViewModel'},
    	
    layout: 'fit',
    items: [{xtype:'employeeAssessmentPanel'}]
});