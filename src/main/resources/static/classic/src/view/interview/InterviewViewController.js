Ext.define('Admin.view.interview.InterviewViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.interviewViewController',
 /*******************************弹窗按钮***********************************/
         /*编辑修改弹窗按钮*/
	openInterviewEditWindow:function(grid, rowIndex, colIndex){
		var record = grid.getStore().getAt(rowIndex);
		if (record ) {
			var win = grid.up('container').add(Ext.widget('interviewEditWindow'));
	             win.show();	      
		      win.down('form').getForm().loadRecord(record);
	      }
	},
	/*多条件查询弹窗按钮*/	
	openInterviewSearchWindow:function(toolbar, rowIndex, colIndex){
		toolbar.up('grid').up('container').add(Ext.widget('interviewSearchWindow')).show();		
	},
	/*添加记录弹窗按钮*/	
	openInterviewAddWindow:function(grid, rowIndex, colIndex){
		grid.up('container').up('gridpanel').add(Ext.widget('interviewAddWindow')).show();
	},
 /*******************************点击按钮***********************************/
	/*分类单条件查询（快速查询）按钮*/
	quickSearch:function(button){
		var searchField = this.lookupReference('searchFieldName').getValue();
		var searchFieldValue = this.lookupReference('searchFieldValue').getValue();
		var searchDateFieldValue1 = this.lookupReference('searchDateFieldValue1').getValue();
		var searchDateFieldValue2 = this.lookupReference('searchDateFieldValue2').getValue();
		var store =	button.up('gridpanel').getStore();
		//var store = Ext.getCmp('userGridPanel').getStore();// Ext.getCmp(）需要在OrderPanel设置id属性
		Ext.apply(store.proxy.extraParams, {state:"",examResult:"",createTimeStart:"",createTimeEnd:""});
		
		if(searchField==='state'){
			Ext.apply(store.proxy.extraParams, {state:searchFieldValue});
		}
		if(searchField==='createTime'){
			Ext.apply(store.proxy.extraParams, {createTimeStart:Ext.util.Format.date(searchDateFieldValue1, 'Y/m/d H:i:s'),createTimeEnd:Ext.util.Format.date(searchDateFieldValue2, 'Y/m/d H:i:s')});
		}
		store.load({params:{start:0, limit:20, page:1}});
	},
	/*删除多行按钮*/
	deleteMoreRows:function(button, rowIndex, colIndex){
		var grid = button.up('gridpanel');
  		var selModel = grid.getSelectionModel();
  		if (selModel.hasSelection()) {
    			Ext.Msg.confirm('警告', '确定要删除吗？', function(btn) {
      			if (btn == 'yes') {
        				var rows = selModel.getSelection();
        				var selectIds = [];
        				Ext.each(rows, function(row) {
          					selectIds.push(row.data.id);
        				});
        				Ext.Ajax.request({url:'/interview/deletes', method:'post', params:{ids:selectIds}, success:function(response, options) {
          					var json = Ext.util.JSON.decode(response.responseText);
          					if (json.success) {
            					Ext.Msg.alert('操作成功', json.msg, function() {
              						grid.getStore().reload();
            					});
         				 	} else {
            					Ext.Msg.alert('操作失败', json.msg);
          					}
       				 }});
      			}
    		});
  	} else {
    		Ext.Msg.alert('错误', '没有任何行被选中，无法进行删除操作！');
 	 }
},
	   /*删除一行按钮*/	
	deleteOneRow:function(grid,rowIndex,colIndex){
		 Ext.MessageBox.confirm('提示', '确定要进行删除操作吗？', function(button, text) {
	   		 if (button == 'yes') {
				var store = grid.getStore();
				var record = store.getAt(rowIndex);
				store.remove(record);
			}
		},this);
	},
	/*禁用一行按钮*/
	onDisableButton:function(grid, rowIndex, colIndex){
		 Ext.MessageBox.confirm('提示', '确定要进行禁用操作吗？', function(button, text) {
	   		 if (button == 'yes') {
				var store = grid.getStore();
				var record = store.getAt(rowIndex);
				store.remove(record);
			}
		},this);
	},
 /*******************************监听按钮***********************************/
	/*combobox选中后监听控制对应输入（文本框和日期框）框显示隐藏*/
	searchComboboxSelectChuang:function(combo,record,index){
		//alert(record.data.name);
		var searchField = this.lookupReference('searchFieldName').getValue();
		if(searchField==='createTime'){
			this.lookupReference('searchFieldValue').hide();
			this.lookupReference('searchDateFieldValue1').show();
			this.lookupReference('searchDateFieldValue2').show();
		}else{
			this.lookupReference('searchFieldValue').show();
			this.lookupReference('searchDateFieldValue1').hide();
			this.lookupReference('searchDateFieldValue2').hide();
		}	
	},
/*******************************提交按钮***********************************/
	/*编辑一条记录保存按钮*/
	interviewEditSubmitButton:function(button){
		var win=button.up('window');
		var  store=Ext.data.StoreManager.lookup('interviewStore')
	      var values=win.down('form').getValues();//获得form数据
	       var record=store.getById(values.id);//获取id获取store中的数据
		record.set(values);
		store.load();
		win.close();
		//更新事件
	},
	/*添加一条记录提交按钮*/
	interviewAddSubmitButton:function(button){
		var win=button.up('window')
		var form=win.down('form');
		var record = Ext.create('Admin.model.interview.InterviewModel');
		var values  =form.getValues();//获取form数据 
			console.log(values);
           	record.set(values);
           	record.save();
           	Ext.data.StoreManager.lookup('interviewStore').load();
             win.close();
	},
	/*查询多条记录条件提交按钮*/
	interviewSearchSubmitButton:function(button){
		var store = Ext.data.StoreManager.lookup('interviewStore');	
		var win=button.up('window');
		var form=win.down('form');
		var values = form.getValues();
		Ext.apply(store.proxy.extraParams, {state:'',createTimeStart:'', createTimeEnd:''});
		Ext.apply(store.proxy.extraParams, {state:values.state,createTimeStart:Ext.util.Format.date(values.createTimeStart, 'Y/m/d H:i:s'), createTimeEnd:Ext.util.Format.date(values.createTimeEnd, 'Y/m/d H:i:s')});
		store.load({params:{start:0, limit:20, page:1}});
		win.close();
	}
});
