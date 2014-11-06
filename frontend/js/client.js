/*
Copyright (c) 2014 Advanced Community Information Systems (ACIS) Group,
Chair of Computer Science 5 (Databases & Information Systems), RWTH Aachen University, Germany
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, this
  list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice,
  this list of conditions and the following disclaimer in the documentation
  and/or other materials provided with the distribution.

* Neither the name of the ACIS Group nor the names of its
  contributors may be used to endorse or promote products derived from
  this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

function TemplateServiceClient(endpointUrl) {
	// care for trailing slash in endpoint URL
	if(endpointUrl.endsWith("/")) {
		this._serviceEndpoint = endpointUrl.substr(0,endpointUrl.length-1);
	} else {
		this._serviceEndpoint = endpointUrl;
	}
};

TemplateServiceClient.prototype.getMethod = function(successCallback, errorCallback) {
	this.sendRequest("GET",
		"example/validate",
		"",
		"application/json",
		{},
		successCallback,
		errorCallback
	);
};

TemplateServiceClient.prototype.postMethod = function(input, successCallback, errorCallback) {
	this.sendRequest("POST",
		"example/myMethodPath/" + input,
		"",
		"application/json",
		{},
		successCallback,
		errorCallback
	);
};

TemplateServiceClient.prototype.sendRequest = function(method, relativePath, content, mime, customHeaders, successCallback, errorCallback) {
	var mtype = "text/plain; charset=UTF-8"
	if(mime !== 'undefined') {
		mtype = mime;
	}
	
	var ajaxObj = {
		url: this._serviceEndpoint + "/" + relativePath,
		type: method.toUpperCase(),
		data: content,
		contentType: mtype,
		crossDomain: true,
		headers: {},
		
		error: function (xhr, errorType, error) {
			console.log(error);
			var errorText = error;
			if (xhr.responseText != null && xhr.responseText.trim().length > 0) {
				errorText = xhr.responseText;
			}
			errorCallback(errorText);
		},
		success: function (data, status, xhr) {
			var type = xhr.getResponseHeader("Content-Type");
			successCallback(data, type);
		},
	};
	
	if (customHeaders !== undefined && customHeaders !== null) {
		$.extend(ajaxObj.headers, customHeaders);
	}
	
	$.ajax(ajaxObj);
};

String.prototype.endsWith = function(suffix) {
	return this.indexOf(suffix, this.length - suffix.length) !== -1;
};