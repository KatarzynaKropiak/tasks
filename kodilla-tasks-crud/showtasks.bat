call runcrud.bat
if "%ERRORLEVEL%" == "0" goto openchrome
echo.
echo RUNCRUD.BAT has errors – breaking work
goto fail

:openchrome
start Chrome http://localhost:8080/crud/v1/tasks

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.