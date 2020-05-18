import jenkins.model.*
jenkins = Jenkins.instance

def qps_plugins = [
'ace-editor':'1.1',
'ansicolor':'0.6.3',
'ant':'1.11',
'antisamy-markup-formatter':'2.0',
'apache-httpcomponents-client-4-api':'4.5.10-2.0',
'authentication-tokens':'1.3',
'aws-credentials':'1.28',
'aws-java-sdk':'1.11.723',
'bouncycastle-api':'2.18',
'branch-api':'2.5.6',
'build-name-setter':'2.0.4',
'build-timeout':'1.19.1',
'build-user-vars-plugin':'1.5',
'categorized-view':'1.10',
'cloudbees-folder':'6.12',
'command-launcher':'1.4',
'config-file-provider':'3.6.3',
'credentials-binding':'1.22',
'credentials':'2.3.7',
'display-url-api':'2.3.2',
'docker-commons':'1.16',
'docker-workflow':'1.23',
'durable-task':'1.34',
'email-ext':'2.69',
'embeddable-build-status':'2.0.3',
'extensible-choice-parameter':'1.6.0',
'external-monitor-job':'1.7',
'ghprb':'1.42.1',
'git-client':'3.2.1',
'git-server':'1.9',
'git':'4.2.2',
'github-api':'1.111',
'github':'1.29.5',
'global-variable-string-parameter':'1.2',
'gradle':'1.36',
'h2-api':'1.4.199',
'handlebars':'1.1.1',
'hidden-parameter':'0.0.4',
'htmlpublisher':'1.22',
'http_request':'1.8.26',
'jackson2-api':'2.11.0',
'javadoc':'1.5',
'jdk-tool':'1.4',
'job-dsl':'1.77',
'jobConfigHistory':'2.26',
'jquery-detached':'1.2.1',
'jsch':'0.1.55.2',
'junit':'1.29',
'ldap':'1.24',
'lockable-resources':'2.8',
'mailer':'1.32',
'mapdb-api':'1.0.9.0',
'matrix-auth':'2.6',
'matrix-project':'1.14',
'momentjs':'1.1.1',
'next-build-number':'1.6',
'ownership':'0.12.1',
'pam-auth':'1.6',
'parameterized-trigger':'2.36',
'pipeline-aws':'1.41',
'pipeline-build-step':'2.12',
'pipeline-github-lib':'1.0',
'pipeline-graph-analysis':'1.10',
'pipeline-input-step':'2.11',
'pipeline-maven':'3.8.2',
'pipeline-milestone-step':'1.3.1',
'pipeline-model-api':'1.6.0',
'pipeline-model-declarative-agent':'1.1.1',
'pipeline-model-definition':'1.6.0',
'pipeline-model-extensions':'1.6.0',
'pipeline-rest-api':'2.13',
'pipeline-stage-step':'2.3',
'pipeline-stage-tags-metadata':'1.6.0',
'pipeline-stage-view':'2.13',
'pipeline-utility-steps':'2.5.0',
'plain-credentials':'1.7',
'PrioritySorter':'3.6.0',
'random-string-parameter':'1.0',
'rebuild':'1.31',
'resource-disposer':'0.14',
'sbt':'1.5',
'scm-api':'2.6.3',
'script-security':'1.71',
'slack':'2.40',
'sonar':'2.11',
'ssh-credentials':'1.18.1',
'ssh-slaves':'1.31.2',
'structs':'1.20',
'subversion':'2.13.1',
'swarm':'3.19',
'timestamper':'1.11.3',
'token-macro':'2.12',
'trilead-api':'1.0.6',
'variant':'1.3',
'view-job-filters':'2.2',
'windows-slaves':'1.6',
'workflow-aggregator':'2.6',
'workflow-api':'2.40',
'workflow-basic-steps':'2.20',
'workflow-cps-global-lib':'2.16',
'workflow-cps':'2.80',
'workflow-durable-task-step':'2.35',
'workflow-job':'2.39',
'workflow-multibranch':'2.21',
'workflow-scm-step':'2.11',
'workflow-step-api':'2.22',
'workflow-support':'3.4',
'ws-cleanup':'0.38'
]


def install_plugins(plugins_map){
	def entries = plugins_map.entrySet()
	entries.each { entry ->
	  println "${entry.key}:${entry.value}"
	  def plugin = jenkins.instance.updateCenter.getPlugin(entry.key, new hudson.util.VersionNumber(entry.value))
	  if (plugin != null) {
	    plugin.deploy()
	  } else {
	    println("ERROR! Unable to get plugin ${entry.key}:${entry.value}!")
	  }
	}
}


println "Installing qps-infra plugins required for jenkins:"
install_plugins(qps_plugins)
