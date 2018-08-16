FROM microsoft/windowsservercore

RUN ["powershell", "New-Item", "c:/test"]
