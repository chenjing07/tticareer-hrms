Ext.define('Admin.view.interview.InterviewEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.interviewEditWindow',

    height: 200,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'Interview Edit Window',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Edit Interview Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: 'Resume Id',
            name:'resumeId'
        }, {
            xtype: 'textfield',
            fieldLabel: 'One Content',
            name:'oneContent'
        }, {
            xtype: 'datefield',
            fieldLabel: 'One Start',
            name:'oneStart',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: 'One End',
            name:'oneEnd',
            format: 'Y/m/d H:i:s'
        },{
            xtype: 'textfield',
            fieldLabel: 'One Feedback',
            name:'oneFeedback'
        },{
            xtype: 'textfield',
            fieldLabel: 'Two Content',
            name:'twoContent'
        }, {
            xtype: 'datefield',
            fieldLabel: 'Two Start',
            name:'twoStart',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: 'Two End',
            name:'twoEnd',
            format: 'Y/m/d H:i:s'
        },{
            xtype: 'textfield',
            fieldLabel: 'Two Feedback',
            name:'twoFeedback'
        },{
            xtype: 'combobox',
            name: 'state',
            bind: '{state}',     
            store:Ext.create("Ext.data.Store", {
		    fields: ["name", "value"],
		    data: [
		      	{ name: '落选', value: '0' },
	  			{ name: '一面', value: '1' },
	  			{ name: '二面', value: '2' }
		    ]
		}),
        displayField: 'name',
        valueField:'value',
        selectOnFocus:false,
        editable: false,
        queryMode: 'local',
        emptyText: 'State'
        },{
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
    buttons:  ['->',{
        xtype: 'button',
        text: 'Submit',
        handler: 'interviewEditSubmitButton'//预留提交事件，在ViewController中实现。
	},'-',{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }]
});
