Ext.define('Admin.view.expenseaccount.ExpenseAccountEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.expenseAccountEditWindow',

	autoShow:true,
    height: 500,
    minHeight: 10,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'ExpenseAccount Edit Window',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    layout: {  
        type: 'hbox',  
        align: 'center',  
        pack: 'center'  
    }, 
    items: [{
		scrollable: true,
        xtype: 'form',
        layout: {type:'vbox',align:'stretch'},
        padding: '10px',
        ariaLabel: 'Edit ExpenseAccount Information',
        items: [{
        	field:'10px',
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '员工编号',
            name:'userName'
        },{ 
        	xtype: 'datefield',
            fieldLabel: '报销日期',
            name:'time',
            format: 'Y/m/d H:i:s'          	
         },{ 
        	xtype: 'textfield',
            fieldLabel: '报销金额',
            name:'amount'
         },{
            xtype: 'textfield',
            fieldLabel: '报销原因',
            name:'reason'
        },{
            xtype: 'textfield',
            fieldLabel: '报销内容',
            name:'content'
        },{
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'note'
        }
	]
    }],
    buttons:  [{
        xtype: 'button',
        text: 'Submit',
        handler: 'editSubmitButton'//预留提交事件，在ViewController中实现。
    },{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }],

});
