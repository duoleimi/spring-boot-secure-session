<#assign ctx=springMacroRequestContext.getContextPath()>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link rel="icon" href="/favicon.ico">
	    <title>登录</title>	
	</head>

	<body class="gray-bg">	
	    <div class="loginColumns animated fadeInDown loginbox">
	        <div class='row'>
	        	<div class="col-md-4"></div>
	            <div class="col-md-4">
	            	<div class="ibox-content">
	            		<h2 class="text-center">test</h2>
			            <form id='loginform' method="POST" class="m-t" role="form" action="${ctx}/login" onsubmit="return checkFields()">	            	
			                <div style="margin-bottom:28px" class="form-group">
			                    <input type="text" name='username' id='loginName' class="form-control " placeholder="用户名" >
			                    <span style="float:left" class="text-danger errtips"></span>
			                </div>
			                <div class="form-group" style="margin-bottom:28px">
			                    <input type="password" autocomplete="off" name='password' id='password' class="form-control" placeholder="登录密码" >
			                    <span style="float:left" class="text-danger errtips"></span>
			                </div>
			                <button id='loginBtn' type="submit" class="btn btn-primary block full-width m-b">登录</button>
							<div class="form-group text-left">
								<div class="checkbox checkbox-success">
									<input id="checkbox1" type="checkbox" name="danger">
									<label for="checkbox1">
										记住密码
									</label>
								</div>
							</div>
			            </form>
	            	</div>
	            </div>
	            <div class="col-md-4"></div>
	        </div>
		    <hr/>
	    </div>
	</body>
</html>