package com.example.nikita.githubtest;


import android.util.Base64;

import org.json.JSONArray;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkUtils {

    public static JSONArray getJSONArraya() {
        try {
            String s = "[\n" +
                    "  {\n" +
                    "    \"id\": 122351468,\n" +
                    "    \"name\": \"SecondTest\",\n" +
                    "    \"full_name\": \"mSustain/SecondTest\",\n" +
                    "    \"owner\": {\n" +
                    "      \"login\": \"mSustain\",\n" +
                    "      \"id\": 36679259,\n" +
                    "      \"avatar_url\": \"https://avatars1.githubusercontent.com/u/36679259?v=4\",\n" +
                    "      \"gravatar_id\": \"\",\n" +
                    "      \"url\": \"https://api.github.com/users/mSustain\",\n" +
                    "      \"html_url\": \"https://github.com/mSustain\",\n" +
                    "      \"followers_url\": \"https://api.github.com/users/mSustain/followers\",\n" +
                    "      \"following_url\": \"https://api.github.com/users/mSustain/following{/other_user}\",\n" +
                    "      \"gists_url\": \"https://api.github.com/users/mSustain/gists{/gist_id}\",\n" +
                    "      \"starred_url\": \"https://api.github.com/users/mSustain/starred{/owner}{/repo}\",\n" +
                    "      \"subscriptions_url\": \"https://api.github.com/users/mSustain/subscriptions\",\n" +
                    "      \"organizations_url\": \"https://api.github.com/users/mSustain/orgs\",\n" +
                    "      \"repos_url\": \"https://api.github.com/users/mSustain/repos\",\n" +
                    "      \"events_url\": \"https://api.github.com/users/mSustain/events{/privacy}\",\n" +
                    "      \"received_events_url\": \"https://api.github.com/users/mSustain/received_events\",\n" +
                    "      \"type\": \"User\",\n" +
                    "      \"site_admin\": false\n" +
                    "    },\n" +
                    "    \"private\": false,\n" +
                    "    \"html_url\": \"https://github.com/mSustain/SecondTest\",\n" +
                    "    \"description\": \"SecondTest\",\n" +
                    "    \"fork\": false,\n" +
                    "    \"url\": \"https://api.github.com/repos/mSustain/SecondTest\",\n" +
                    "    \"forks_url\": \"https://api.github.com/repos/mSustain/SecondTest/forks\",\n" +
                    "    \"keys_url\": \"https://api.github.com/repos/mSustain/SecondTest/keys{/key_id}\",\n" +
                    "    \"collaborators_url\": \"https://api.github.com/repos/mSustain/SecondTest/collaborators{/collaborator}\",\n" +
                    "    \"teams_url\": \"https://api.github.com/repos/mSustain/SecondTest/teams\",\n" +
                    "    \"hooks_url\": \"https://api.github.com/repos/mSustain/SecondTest/hooks\",\n" +
                    "    \"issue_events_url\": \"https://api.github.com/repos/mSustain/SecondTest/issues/events{/number}\",\n" +
                    "    \"events_url\": \"https://api.github.com/repos/mSustain/SecondTest/events\",\n" +
                    "    \"assignees_url\": \"https://api.github.com/repos/mSustain/SecondTest/assignees{/user}\",\n" +
                    "    \"branches_url\": \"https://api.github.com/repos/mSustain/SecondTest/branches{/branch}\",\n" +
                    "    \"tags_url\": \"https://api.github.com/repos/mSustain/SecondTest/tags\",\n" +
                    "    \"blobs_url\": \"https://api.github.com/repos/mSustain/SecondTest/git/blobs{/sha}\",\n" +
                    "    \"git_tags_url\": \"https://api.github.com/repos/mSustain/SecondTest/git/tags{/sha}\",\n" +
                    "    \"git_refs_url\": \"https://api.github.com/repos/mSustain/SecondTest/git/refs{/sha}\",\n" +
                    "    \"trees_url\": \"https://api.github.com/repos/mSustain/SecondTest/git/trees{/sha}\",\n" +
                    "    \"statuses_url\": \"https://api.github.com/repos/mSustain/SecondTest/statuses/{sha}\",\n" +
                    "    \"languages_url\": \"https://api.github.com/repos/mSustain/SecondTest/languages\",\n" +
                    "    \"stargazers_url\": \"https://api.github.com/repos/mSustain/SecondTest/stargazers\",\n" +
                    "    \"contributors_url\": \"https://api.github.com/repos/mSustain/SecondTest/contributors\",\n" +
                    "    \"subscribers_url\": \"https://api.github.com/repos/mSustain/SecondTest/subscribers\",\n" +
                    "    \"subscription_url\": \"https://api.github.com/repos/mSustain/SecondTest/subscription\",\n" +
                    "    \"commits_url\": \"https://api.github.com/repos/mSustain/SecondTest/commits{/sha}\",\n" +
                    "    \"git_commits_url\": \"https://api.github.com/repos/mSustain/SecondTest/git/commits{/sha}\",\n" +
                    "    \"comments_url\": \"https://api.github.com/repos/mSustain/SecondTest/comments{/number}\",\n" +
                    "    \"issue_comment_url\": \"https://api.github.com/repos/mSustain/SecondTest/issues/comments{/number}\",\n" +
                    "    \"contents_url\": \"https://api.github.com/repos/mSustain/SecondTest/contents/{+path}\",\n" +
                    "    \"compare_url\": \"https://api.github.com/repos/mSustain/SecondTest/compare/{base}...{head}\",\n" +
                    "    \"merges_url\": \"https://api.github.com/repos/mSustain/SecondTest/merges\",\n" +
                    "    \"archive_url\": \"https://api.github.com/repos/mSustain/SecondTest/{archive_format}{/ref}\",\n" +
                    "    \"downloads_url\": \"https://api.github.com/repos/mSustain/SecondTest/downloads\",\n" +
                    "    \"issues_url\": \"https://api.github.com/repos/mSustain/SecondTest/issues{/number}\",\n" +
                    "    \"pulls_url\": \"https://api.github.com/repos/mSustain/SecondTest/pulls{/number}\",\n" +
                    "    \"milestones_url\": \"https://api.github.com/repos/mSustain/SecondTest/milestones{/number}\",\n" +
                    "    \"notifications_url\": \"https://api.github.com/repos/mSustain/SecondTest/notifications{?since,all,participating}\",\n" +
                    "    \"labels_url\": \"https://api.github.com/repos/mSustain/SecondTest/labels{/name}\",\n" +
                    "    \"releases_url\": \"https://api.github.com/repos/mSustain/SecondTest/releases{/id}\",\n" +
                    "    \"deployments_url\": \"https://api.github.com/repos/mSustain/SecondTest/deployments\",\n" +
                    "    \"created_at\": \"2018-02-21T15:08:00Z\",\n" +
                    "    \"updated_at\": \"2018-02-21T15:08:00Z\",\n" +
                    "    \"pushed_at\": \"2018-02-21T15:08:01Z\",\n" +
                    "    \"git_url\": \"git://github.com/mSustain/SecondTest.git\",\n" +
                    "    \"ssh_url\": \"git@github.com:mSustain/SecondTest.git\",\n" +
                    "    \"clone_url\": \"https://github.com/mSustain/SecondTest.git\",\n" +
                    "    \"svn_url\": \"https://github.com/mSustain/SecondTest\",\n" +
                    "    \"homepage\": null,\n" +
                    "    \"size\": 0,\n" +
                    "    \"stargazers_count\": 0,\n" +
                    "    \"watchers_count\": 0,\n" +
                    "    \"language\": null,\n" +
                    "    \"has_issues\": true,\n" +
                    "    \"has_projects\": true,\n" +
                    "    \"has_downloads\": true,\n" +
                    "    \"has_wiki\": true,\n" +
                    "    \"has_pages\": false,\n" +
                    "    \"forks_count\": 0,\n" +
                    "    \"mirror_url\": null,\n" +
                    "    \"archived\": false,\n" +
                    "    \"open_issues_count\": 0,\n" +
                    "    \"license\": null,\n" +
                    "    \"forks\": 0,\n" +
                    "    \"open_issues\": 0,\n" +
                    "    \"watchers\": 0,\n" +
                    "    \"default_branch\": \"master\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 122350882,\n" +
                    "    \"name\": \"test\",\n" +
                    "    \"full_name\": \"mSustain/test\",\n" +
                    "    \"owner\": {\n" +
                    "      \"login\": \"mSustain\",\n" +
                    "      \"id\": 36679259,\n" +
                    "      \"avatar_url\": \"https://avatars1.githubusercontent.com/u/36679259?v=4\",\n" +
                    "      \"gravatar_id\": \"\",\n" +
                    "      \"url\": \"https://api.github.com/users/mSustain\",\n" +
                    "      \"html_url\": \"https://github.com/mSustain\",\n" +
                    "      \"followers_url\": \"https://api.github.com/users/mSustain/followers\",\n" +
                    "      \"following_url\": \"https://api.github.com/users/mSustain/following{/other_user}\",\n" +
                    "      \"gists_url\": \"https://api.github.com/users/mSustain/gists{/gist_id}\",\n" +
                    "      \"starred_url\": \"https://api.github.com/users/mSustain/starred{/owner}{/repo}\",\n" +
                    "      \"subscriptions_url\": \"https://api.github.com/users/mSustain/subscriptions\",\n" +
                    "      \"organizations_url\": \"https://api.github.com/users/mSustain/orgs\",\n" +
                    "      \"repos_url\": \"https://api.github.com/users/mSustain/repos\",\n" +
                    "      \"events_url\": \"https://api.github.com/users/mSustain/events{/privacy}\",\n" +
                    "      \"received_events_url\": \"https://api.github.com/users/mSustain/received_events\",\n" +
                    "      \"type\": \"User\",\n" +
                    "      \"site_admin\": false\n" +
                    "    },\n" +
                    "    \"private\": false,\n" +
                    "    \"html_url\": \"https://github.com/mSustain/test\",\n" +
                    "    \"description\": \"This is primary test rep\",\n" +
                    "    \"fork\": false,\n" +
                    "    \"url\": \"https://api.github.com/repos/mSustain/test\",\n" +
                    "    \"forks_url\": \"https://api.github.com/repos/mSustain/test/forks\",\n" +
                    "    \"keys_url\": \"https://api.github.com/repos/mSustain/test/keys{/key_id}\",\n" +
                    "    \"collaborators_url\": \"https://api.github.com/repos/mSustain/test/collaborators{/collaborator}\",\n" +
                    "    \"teams_url\": \"https://api.github.com/repos/mSustain/test/teams\",\n" +
                    "    \"hooks_url\": \"https://api.github.com/repos/mSustain/test/hooks\",\n" +
                    "    \"issue_events_url\": \"https://api.github.com/repos/mSustain/test/issues/events{/number}\",\n" +
                    "    \"events_url\": \"https://api.github.com/repos/mSustain/test/events\",\n" +
                    "    \"assignees_url\": \"https://api.github.com/repos/mSustain/test/assignees{/user}\",\n" +
                    "    \"branches_url\": \"https://api.github.com/repos/mSustain/test/branches{/branch}\",\n" +
                    "    \"tags_url\": \"https://api.github.com/repos/mSustain/test/tags\",\n" +
                    "    \"blobs_url\": \"https://api.github.com/repos/mSustain/test/git/blobs{/sha}\",\n" +
                    "    \"git_tags_url\": \"https://api.github.com/repos/mSustain/test/git/tags{/sha}\",\n" +
                    "    \"git_refs_url\": \"https://api.github.com/repos/mSustain/test/git/refs{/sha}\",\n" +
                    "    \"trees_url\": \"https://api.github.com/repos/mSustain/test/git/trees{/sha}\",\n" +
                    "    \"statuses_url\": \"https://api.github.com/repos/mSustain/test/statuses/{sha}\",\n" +
                    "    \"languages_url\": \"https://api.github.com/repos/mSustain/test/languages\",\n" +
                    "    \"stargazers_url\": \"https://api.github.com/repos/mSustain/test/stargazers\",\n" +
                    "    \"contributors_url\": \"https://api.github.com/repos/mSustain/test/contributors\",\n" +
                    "    \"subscribers_url\": \"https://api.github.com/repos/mSustain/test/subscribers\",\n" +
                    "    \"subscription_url\": \"https://api.github.com/repos/mSustain/test/subscription\",\n" +
                    "    \"commits_url\": \"https://api.github.com/repos/mSustain/test/commits{/sha}\",\n" +
                    "    \"git_commits_url\": \"https://api.github.com/repos/mSustain/test/git/commits{/sha}\",\n" +
                    "    \"comments_url\": \"https://api.github.com/repos/mSustain/test/comments{/number}\",\n" +
                    "    \"issue_comment_url\": \"https://api.github.com/repos/mSustain/test/issues/comments{/number}\",\n" +
                    "    \"contents_url\": \"https://api.github.com/repos/mSustain/test/contents/{+path}\",\n" +
                    "    \"compare_url\": \"https://api.github.com/repos/mSustain/test/compare/{base}...{head}\",\n" +
                    "    \"merges_url\": \"https://api.github.com/repos/mSustain/test/merges\",\n" +
                    "    \"archive_url\": \"https://api.github.com/repos/mSustain/test/{archive_format}{/ref}\",\n" +
                    "    \"downloads_url\": \"https://api.github.com/repos/mSustain/test/downloads\",\n" +
                    "    \"issues_url\": \"https://api.github.com/repos/mSustain/test/issues{/number}\",\n" +
                    "    \"pulls_url\": \"https://api.github.com/repos/mSustain/test/pulls{/number}\",\n" +
                    "    \"milestones_url\": \"https://api.github.com/repos/mSustain/test/milestones{/number}\",\n" +
                    "    \"notifications_url\": \"https://api.github.com/repos/mSustain/test/notifications{?since,all,participating}\",\n" +
                    "    \"labels_url\": \"https://api.github.com/repos/mSustain/test/labels{/name}\",\n" +
                    "    \"releases_url\": \"https://api.github.com/repos/mSustain/test/releases{/id}\",\n" +
                    "    \"deployments_url\": \"https://api.github.com/repos/mSustain/test/deployments\",\n" +
                    "    \"created_at\": \"2018-02-21T15:03:20Z\",\n" +
                    "    \"updated_at\": \"2018-02-21T15:03:20Z\",\n" +
                    "    \"pushed_at\": \"2018-02-21T16:04:45Z\",\n" +
                    "    \"git_url\": \"git://github.com/mSustain/test.git\",\n" +
                    "    \"ssh_url\": \"git@github.com:mSustain/test.git\",\n" +
                    "    \"clone_url\": \"https://github.com/mSustain/test.git\",\n" +
                    "    \"svn_url\": \"https://github.com/mSustain/test\",\n" +
                    "    \"homepage\": null,\n" +
                    "    \"size\": 0,\n" +
                    "    \"stargazers_count\": 0,\n" +
                    "    \"watchers_count\": 0,\n" +
                    "    \"language\": null,\n" +
                    "    \"has_issues\": true,\n" +
                    "    \"has_projects\": true,\n" +
                    "    \"has_downloads\": true,\n" +
                    "    \"has_wiki\": true,\n" +
                    "    \"has_pages\": false,\n" +
                    "    \"forks_count\": 0,\n" +
                    "    \"mirror_url\": null,\n" +
                    "    \"archived\": false,\n" +
                    "    \"open_issues_count\": 0,\n" +
                    "    \"license\": null,\n" +
                    "    \"forks\": 0,\n" +
                    "    \"open_issues\": 0,\n" +
                    "    \"watchers\": 0,\n" +
                    "    \"default_branch\": \"master\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 122351504,\n" +
                    "    \"name\": \"ThirdOne\",\n" +
                    "    \"full_name\": \"mSustain/ThirdOne\",\n" +
                    "    \"owner\": {\n" +
                    "      \"login\": \"mSustain\",\n" +
                    "      \"id\": 36679259,\n" +
                    "      \"avatar_url\": \"https://avatars1.githubusercontent.com/u/36679259?v=4\",\n" +
                    "      \"gravatar_id\": \"\",\n" +
                    "      \"url\": \"https://api.github.com/users/mSustain\",\n" +
                    "      \"html_url\": \"https://github.com/mSustain\",\n" +
                    "      \"followers_url\": \"https://api.github.com/users/mSustain/followers\",\n" +
                    "      \"following_url\": \"https://api.github.com/users/mSustain/following{/other_user}\",\n" +
                    "      \"gists_url\": \"https://api.github.com/users/mSustain/gists{/gist_id}\",\n" +
                    "      \"starred_url\": \"https://api.github.com/users/mSustain/starred{/owner}{/repo}\",\n" +
                    "      \"subscriptions_url\": \"https://api.github.com/users/mSustain/subscriptions\",\n" +
                    "      \"organizations_url\": \"https://api.github.com/users/mSustain/orgs\",\n" +
                    "      \"repos_url\": \"https://api.github.com/users/mSustain/repos\",\n" +
                    "      \"events_url\": \"https://api.github.com/users/mSustain/events{/privacy}\",\n" +
                    "      \"received_events_url\": \"https://api.github.com/users/mSustain/received_events\",\n" +
                    "      \"type\": \"User\",\n" +
                    "      \"site_admin\": false\n" +
                    "    },\n" +
                    "    \"private\": false,\n" +
                    "    \"html_url\": \"https://github.com/mSustain/ThirdOne\",\n" +
                    "    \"description\": \"ThirdTest\",\n" +
                    "    \"fork\": false,\n" +
                    "    \"url\": \"https://api.github.com/repos/mSustain/ThirdOne\",\n" +
                    "    \"forks_url\": \"https://api.github.com/repos/mSustain/ThirdOne/forks\",\n" +
                    "    \"keys_url\": \"https://api.github.com/repos/mSustain/ThirdOne/keys{/key_id}\",\n" +
                    "    \"collaborators_url\": \"https://api.github.com/repos/mSustain/ThirdOne/collaborators{/collaborator}\",\n" +
                    "    \"teams_url\": \"https://api.github.com/repos/mSustain/ThirdOne/teams\",\n" +
                    "    \"hooks_url\": \"https://api.github.com/repos/mSustain/ThirdOne/hooks\",\n" +
                    "    \"issue_events_url\": \"https://api.github.com/repos/mSustain/ThirdOne/issues/events{/number}\",\n" +
                    "    \"events_url\": \"https://api.github.com/repos/mSustain/ThirdOne/events\",\n" +
                    "    \"assignees_url\": \"https://api.github.com/repos/mSustain/ThirdOne/assignees{/user}\",\n" +
                    "    \"branches_url\": \"https://api.github.com/repos/mSustain/ThirdOne/branches{/branch}\",\n" +
                    "    \"tags_url\": \"https://api.github.com/repos/mSustain/ThirdOne/tags\",\n" +
                    "    \"blobs_url\": \"https://api.github.com/repos/mSustain/ThirdOne/git/blobs{/sha}\",\n" +
                    "    \"git_tags_url\": \"https://api.github.com/repos/mSustain/ThirdOne/git/tags{/sha}\",\n" +
                    "    \"git_refs_url\": \"https://api.github.com/repos/mSustain/ThirdOne/git/refs{/sha}\",\n" +
                    "    \"trees_url\": \"https://api.github.com/repos/mSustain/ThirdOne/git/trees{/sha}\",\n" +
                    "    \"statuses_url\": \"https://api.github.com/repos/mSustain/ThirdOne/statuses/{sha}\",\n" +
                    "    \"languages_url\": \"https://api.github.com/repos/mSustain/ThirdOne/languages\",\n" +
                    "    \"stargazers_url\": \"https://api.github.com/repos/mSustain/ThirdOne/stargazers\",\n" +
                    "    \"contributors_url\": \"https://api.github.com/repos/mSustain/ThirdOne/contributors\",\n" +
                    "    \"subscribers_url\": \"https://api.github.com/repos/mSustain/ThirdOne/subscribers\",\n" +
                    "    \"subscription_url\": \"https://api.github.com/repos/mSustain/ThirdOne/subscription\",\n" +
                    "    \"commits_url\": \"https://api.github.com/repos/mSustain/ThirdOne/commits{/sha}\",\n" +
                    "    \"git_commits_url\": \"https://api.github.com/repos/mSustain/ThirdOne/git/commits{/sha}\",\n" +
                    "    \"comments_url\": \"https://api.github.com/repos/mSustain/ThirdOne/comments{/number}\",\n" +
                    "    \"issue_comment_url\": \"https://api.github.com/repos/mSustain/ThirdOne/issues/comments{/number}\",\n" +
                    "    \"contents_url\": \"https://api.github.com/repos/mSustain/ThirdOne/contents/{+path}\",\n" +
                    "    \"compare_url\": \"https://api.github.com/repos/mSustain/ThirdOne/compare/{base}...{head}\",\n" +
                    "    \"merges_url\": \"https://api.github.com/repos/mSustain/ThirdOne/merges\",\n" +
                    "    \"archive_url\": \"https://api.github.com/repos/mSustain/ThirdOne/{archive_format}{/ref}\",\n" +
                    "    \"downloads_url\": \"https://api.github.com/repos/mSustain/ThirdOne/downloads\",\n" +
                    "    \"issues_url\": \"https://api.github.com/repos/mSustain/ThirdOne/issues{/number}\",\n" +
                    "    \"pulls_url\": \"https://api.github.com/repos/mSustain/ThirdOne/pulls{/number}\",\n" +
                    "    \"milestones_url\": \"https://api.github.com/repos/mSustain/ThirdOne/milestones{/number}\",\n" +
                    "    \"notifications_url\": \"https://api.github.com/repos/mSustain/ThirdOne/notifications{?since,all,participating}\",\n" +
                    "    \"labels_url\": \"https://api.github.com/repos/mSustain/ThirdOne/labels{/name}\",\n" +
                    "    \"releases_url\": \"https://api.github.com/repos/mSustain/ThirdOne/releases{/id}\",\n" +
                    "    \"deployments_url\": \"https://api.github.com/repos/mSustain/ThirdOne/deployments\",\n" +
                    "    \"created_at\": \"2018-02-21T15:08:21Z\",\n" +
                    "    \"updated_at\": \"2018-02-21T15:08:21Z\",\n" +
                    "    \"pushed_at\": \"2018-02-21T15:08:21Z\",\n" +
                    "    \"git_url\": \"git://github.com/mSustain/ThirdOne.git\",\n" +
                    "    \"ssh_url\": \"git@github.com:mSustain/ThirdOne.git\",\n" +
                    "    \"clone_url\": \"https://github.com/mSustain/ThirdOne.git\",\n" +
                    "    \"svn_url\": \"https://github.com/mSustain/ThirdOne\",\n" +
                    "    \"homepage\": null,\n" +
                    "    \"size\": 0,\n" +
                    "    \"stargazers_count\": 0,\n" +
                    "    \"watchers_count\": 0,\n" +
                    "    \"language\": null,\n" +
                    "    \"has_issues\": true,\n" +
                    "    \"has_projects\": true,\n" +
                    "    \"has_downloads\": true,\n" +
                    "    \"has_wiki\": true,\n" +
                    "    \"has_pages\": false,\n" +
                    "    \"forks_count\": 0,\n" +
                    "    \"mirror_url\": null,\n" +
                    "    \"archived\": false,\n" +
                    "    \"open_issues_count\": 0,\n" +
                    "    \"license\": null,\n" +
                    "    \"forks\": 0,\n" +
                    "    \"open_issues\": 0,\n" +
                    "    \"watchers\": 0,\n" +
                    "    \"default_branch\": \"master\"\n" +
                    "  }\n" +
                    "]";
            JSONArray ja = new JSONArray(s);
            return ja;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }

    public  static String getResponseString(String url, String credits){
                Response response;
                String encodedCredits = Base64.encodeToString(credits.getBytes(), Base64.NO_WRAP);
                try {
                    OkHttpClient client = new OkHttpClient();

                    Request request = new Request.Builder()
                            .url(url)
                            .addHeader("Authorization", "Basic " + encodedCredits.trim())
                            .get()
                            .build();
                    response = client.newCall(request).execute();
                    return response.body().string();
                } catch ( Exception e) {
                    e.printStackTrace();
                }
                return null;
    }
}