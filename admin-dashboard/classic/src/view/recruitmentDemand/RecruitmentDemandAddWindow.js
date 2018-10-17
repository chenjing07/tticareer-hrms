Ext.define('Admin.view.recruitmentDemand.RecruitmentDemandAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.recruitmentDemandAddWindow',

	
    height: 300,
    minHeight: 10,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'RecruitmentDemand Add Window',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
		scrollable: true,
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add RecruitmentDemand Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: 'Position Id',
            name:'positionId'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Plan Number',
            name:'planNumber'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Salary',
            name:'salary'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Supplemental Number',
            name:'supplementalNumber'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Supplement Reason',
            name:'supplementReason'
        },
        {
            xtype: 'datefield',
            fieldLabel: 'Arrival Date',
            name:'arrivalDate',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Language Requirements',
            name:'languageRequirements'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Professional Requirements',
            name:'professionalRequirements'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Educational Requirements',
            name:'educationalRequirements'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Computer Requirements',
            name:'computerRequirements'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Experience Requirements',
            name:'experienceRequirements'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Age Requirements',
            name:'ageRequirements'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Post Duties',
            name:'postDuties'
        }, {
            xtype: 'textfield',
            fieldLabel: 'State',
            name:'state'
        },
        {
            xtype: 'datefield',
            fieldLabel: 'Create Time',
            name:'createTime',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Note',
            name:'note'
        }
	]
    }],
    buttons:  [{
        xtype: 'button',
        text: 'Submit',
        handler: 'recruitmentDemandAddSubmitButton'//预留提交事件，在ViewController中实现。
    },{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }]
});
