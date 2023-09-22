//
//  GithubLogoImage.swift
//  iosApp
//
//  Created by Vika on 21.08.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

fileprivate extension Appearance {
	var githubLogo: String { "githubLogo" }
}

struct GithubLogoImage: View {
	@Environment(\.colorScheme) var colorScheme
	
	private let appearance: Appearance = Appearance()
	
	var body: some View {
		switch colorScheme {
		case .light:
			Image(appearance.githubLogo)
		case .dark:
			Image(appearance.githubLogo)
				.colorInvert()
		}
	}
}
