Ext.define('Admin.view.examination.writtenExaminationContent.WrittenExaminationContentAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.writtenExaminationContentAddWindow',

	
    height: 500,
    minHeight: 200,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'WrittenExaminationContent Add Window',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
		scrollable: true,
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add WrittenExaminationContent Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        },  {
            xtype: 'textfield',
            fieldLabel: 'One Id',
            name:'oneId'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Two Id',
            name:'twoId'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Three Id',
            name:'threeId'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Four Id',
            name:'fourId'
        },{
            xtype: 'textfield',
            fieldLabel: 'Five Id',
            name:'fiveId'
        },{
            xtype: 'textfield',
            fieldLabel: 'Six Id',
            name:'sixId'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Seven Id',
            name:'sevenId'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Eight Id',
            name:'eightId'
        },{
            xtype: 'textfield',
            fieldLabel: 'Nine Id',
            name:'nineId'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Ten Id',
            name:'tenId'
        },{
            xtype: 'combobox',
            fieldLabel: 'State',
            name: 'state',
            bind: '{state}',     
            store:Ext.create("Ext.data.Store", {
		    fields: ["name", "value"],
		    data: [
		      	{ name: '冻结', value: '0' },
	  			{ name: '激活', value: '1' }
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
    buttons:  [{
        xtype: 'button',
        text: 'Submit',
        handler: 'writtenExaminationContentAddSubmitButton'//预留提交事件，在ViewController中实现。
    },{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }]
});
