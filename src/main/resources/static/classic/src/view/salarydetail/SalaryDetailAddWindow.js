Ext.define('Admin.view.salarydetail.SalaryDetailAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.salaryDetailAddWindow',

	autoShow:true,
    height: 500,
    minHeight: 10,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'SalaryDetail Add Window',
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
        ariaLabel: 'Add SalaryDetail Information',
        items: [{
        	field:'10px',
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '员工编号',
            name:'userName'
        }, {
            xtype: 'monthfield',
            fieldLabel: '所属年月',
            name:'nowYearMonth',
            format: 'Y/m/d H:i:s'	
        },{
            xtype: 'textfield',
            fieldLabel: '基础工资',
            name:'basicSalary'
        },{
            xtype: 'textfield',
            fieldLabel: '奖金',
            name:'bonus'
        },{
            xtype: 'textfield',
            fieldLabel: '加班工资',
            name:'overWorkSalary'
        }, {
            xtype: 'textfield',
            fieldLabel: '补贴',
            name:'subsidy'
        },{
            xtype: 'textfield',
            fieldLabel: '考勤需扣工资',
            name:'attendanceDeduction',       
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
        handler: 'addSubmitButton'//预留提交事件，在ViewController中实现。
    },{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }],

});
