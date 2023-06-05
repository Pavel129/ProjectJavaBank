if not exist u:\japp\JInvFore.jar (
  echo Java Disk NOT Mapped
  net use u: \\MSK-FS0\N$ >nul 2>nul
  if exist u:\japp\JInvFore.jar echo Java Disk Map OK
) else (
  echo Java Disk Mapped
)

SET             ORA_HOME=\\msk-fs0\tools\xxi\orant64
SET             XXI_HOME=\\MSK-FS0\N$
SET          ORACLE_HOME=%ORA_HOME%
set            TNS_ADMIN=%ORA_HOME%\network\admin_nxt


set NLS_NUMERIC_CHARACTERS=. .
set        NLS_DATE_FORMAT=DD.MM.RRRR
SET               NLS_LANG=RUSSIAN_CIS.CL8MSWIN1251
SET            XXI_DESKTOP=TRUE
SET            ORACLE_HOME=%ORA_HOME%
set                   PATH=C:\XXI\Start\JRE32\bin;%XXI_HOME%\bin;%ORA_HOME%\bin;C:\XXI\Start\JRE32\bin\client;%systemroot%;%systemroot%\system32
set              CLASSPATH=lib\*;\\MSK-FS0\N$\japp\*

c:\xxi\start\jre32\bin\java.exe -jar JInvFC.jar --ru.inversion.userid=FWFhJL0YsQ0I0TksyMUBOWFRPREI= --ru.inversion.logpath=%~dp0\log 2>&1 >> %~dp0\JInvFC.log