package versioning

import groovy.transform.CompileStatic
import groovy.transform.ToString
import groovy.transform.TypeChecked
import org.joda.time.DateTime

@CompileStatic @TypeChecked
@ToString(includeNames = true)
class MetamodVersionInfo {
	int majorVersion
	int minorVersion
	Integer maintenanceVersion
	String specialVersion
	Integer countCommit
	DateTime lastCommitDate
	String commitID
	String authorCommit
	String urlCommits

	String format(String versionSeparator, String suffixSeparator, boolean includeSuffix) {
		StringBuilder sb = new StringBuilder()
		sb.append(majorVersion).append(versionSeparator).append(minorVersion)
		if (maintenanceVersion != null) {
			sb.append(versionSeparator).append(maintenanceVersion)
		}

		if (specialVersion && includeSuffix) {
			sb.append(suffixSeparator).append(specialVersion)
		}

		return sb.toString()
	}
	String asVersion() {
		StringBuilder sb = new StringBuilder()
		sb.append(majorVersion).append('.' + minorVersion).append('.' + countCommit);
		return sb;
	}
	String asMavenVersion() {
		format('.', '-', true)
	}
}
