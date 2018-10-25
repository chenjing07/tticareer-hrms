Ext.define('Admin.view.salarydetail.SalaryDetailCheckWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.salaryDetailCheckWindow',

	autoShow:true,
    height: 500,
    minHeight: 10,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '薪酬审核',
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
        ariaLabel: 'Check SalaryDetail Information',
        items: [{
        	field:'10px',
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        },{
        	field:'10px',
            xtype: 'textfield',
            fieldLabel: 'employeeId',
            name:'employeeId',
            hidden: true,
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '员工编号',
            name:'userName',
            readOnly: true
        }, {
            xtype: 'monthfield',
            fieldLabel: '所属年月',
            name:'nowYearMonth',
            format: 'Y/m/d H:m:i',	
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '基础工资',
            name:'basicSalary',
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '奖金',
            name:'bonus',
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '加班工资',
            name:'overWorkSalary',
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '补贴',
            name:'subsidy',
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '考勤需扣工资',
            name:'attendanceDeduction', 
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'note',
            readOnly: true
        }
	]
    }],
    buttons:  [{
        xtype: 'button',
        text: '审核',
        handler: 'checkSalaryDetail'//预留提交事件，在ViewController中实现。
    },{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }],

});
